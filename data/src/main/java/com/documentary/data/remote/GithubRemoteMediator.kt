package com.documentary.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Success
import com.documentary.data.BuildConfig
import com.documentary.data.dataSource.*
import com.documentary.data.entities.RemoteKeys
import com.documentary.data.entities.Repo
import com.documentary.data.entities.RepoRequest
import com.documentary.data.services.IN_QUALIFIER
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.io.InvalidObjectException
import javax.inject.Inject

// GitHub page API is 1 based: https://developer.github.com/v3/#pagination
private const val GITHUB_STARTING_PAGE_INDEX = 1

@OptIn(ExperimentalPagingApi::class)
class GithubRemoteMediator @Inject constructor(
    private val localRepoDataSourceDeletable: LocalDataSourceDeletable,
    private val localRepoDataSourceWritable: LocalRepoDataSourceWritable,
    private val localRepoDataSourceReadable: LocalRepoDataSourceReadable,
    private val localRemoteKeyDataSourceWritable: LocalRemoteKeyDataSourceWritable,
    private val localRemoteKeyDataSourceReadable: LocalRemoteKeyDataSourceReadable,
    private val remoteRepoDataSource: RemoteRepoDataSource
) : RemoteMediator<Int, Repo>() {
    lateinit var query: String

    operator fun invoke(parameters: Params): GithubRemoteMediator {
        query = parameters.query
        return this
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Repo>): MediatorResult {

        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: GITHUB_STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                if (remoteKeys == null) {
                    // The LoadType is PREPEND so some data was loaded before,
                    // so we should have been able to get remote keys
                    // If the remoteKeys are null, then we're an invalid state and we have a bug
                    throw InvalidObjectException("Remote key and the prevKey should not be null")
                }
                // If the previous key is null, then we can't request more data
                val prevKey = remoteKeys.prevKey
                if (prevKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                remoteKeys.prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                if (remoteKeys == null || remoteKeys.nextKey == null) {
                    throw InvalidObjectException("Remote key should not be null for $loadType")
                }
                remoteKeys.nextKey
            }

        }

        val apiQuery = query + IN_QUALIFIER

        try {
            val apiResponse = remoteRepoDataSource.read(
                RepoRequest(
                    "https://api.github.com/search/repositories?sort=stars",
                    apiQuery,
                    page,
                    state.config.pageSize
                )
            )
            if (apiResponse is Success && apiResponse != null && apiResponse.data.items.isNotEmpty()) {
                val repos = apiResponse.data.items
                var endOfPaginationReached: Boolean = repos.isEmpty()

                if (loadType == LoadType.REFRESH) {
//                localRemoteKeyDataSourceDeletable.delete(Unit)
                    withContext(Dispatchers.IO) {
                        localRepoDataSourceDeletable.delete(Unit)
                    }
//                    repoDatabase.remoteKeysDao().clearRemoteKeys()
//                    repoDatabase.reposDao().clearRepos()
                }

                val prevKey = if (page == GITHUB_STARTING_PAGE_INDEX) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = repos.map {
                    RemoteKeys(repoId = it.id, prevKey = prevKey, nextKey = nextKey)
                }
                localRemoteKeyDataSourceWritable.write(keys)
                localRepoDataSourceWritable.write(repos)
                if (BuildConfig.FLAVOR == "mock")
                    endOfPaginationReached = true
                return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            } else {
                return MediatorResult.Error((apiResponse as ErrorResult).throwable)
            }

        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Repo>): RemoteKeys? {
        // Get the last page that was retrieved, that contained items.
        // From that last page, get the last item
        return state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { repo ->
                // Get the remote keys of the last item retrieved
                localRemoteKeyDataSourceReadable.read(LocalRemoteKeyDataSourceReadable.Params(repo.id))
//                repoDatabase.remoteKeysDao().remoteKeysRepoId(repo.id)
            }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Repo>): RemoteKeys? {
        // Get the first page that was retrieved, that contained items.
        // From that first page, get the first item
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { repo ->
                // Get the remote keys of the first items retrieved
                localRemoteKeyDataSourceReadable.read(LocalRemoteKeyDataSourceReadable.Params(repo.id))
//                repoDatabase.remoteKeysDao().remoteKeysRepoId(repo.id)
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Repo>
    ): RemoteKeys? {
        // The paging library is trying to load data after the anchor position
        // Get the item closest to the anchor position
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { repoId ->
//                repoDatabase.remoteKeysDao().remoteKeysRepoId(repoId)
                localRemoteKeyDataSourceReadable.read(LocalRemoteKeyDataSourceReadable.Params(repoId))
            }
        }
    }

    data class Params(val query: String)

}