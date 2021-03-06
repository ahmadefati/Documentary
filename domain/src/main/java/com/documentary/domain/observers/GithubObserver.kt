package com.documentary.domain.observers


import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.documentary.data.repos.GithubRepository
import com.documentary.domain.PagingInteractor
import com.documentary.domain.repo.Repo
import com.documentary.domain.repo.toRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class GithubObserver @Inject constructor(
    private val githubRepository: GithubRepository
) : PagingInteractor<GithubObserver.Parameters, Repo>() {

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */

    override fun createObservable(params: Parameters): Flow<PagingData<Repo>> {
        Log.d("GithubRepository", "New query: ${params.query}")

        // appending '%' so we can allow other characters to be before and after the query string
        val dbQuery = "%${params.query.replace(' ', '%')}%"
        val pagingSourceFactory = { githubRepository.getPagingSourceFactory(dbQuery) }

        return Pager(
            config = params.pagingConfig,
            remoteMediator = githubRepository.getGithubRemoteMediator(params.query),
            pagingSourceFactory = pagingSourceFactory
        ).flow.mapLatest { pagingData ->
            pagingData.map { entity ->
                entity.toRepo()
            }
        }

    }

    data class Parameters(
        override val pagingConfig: PagingConfig,
        val query: String

    ) : PagingInteractor.Parameters<Repo>

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }


}