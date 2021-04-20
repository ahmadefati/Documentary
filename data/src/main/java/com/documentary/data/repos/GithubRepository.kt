package com.documentary.data.repos

import androidx.paging.PagingSource
import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.dataSource.LocalRepoDataSource
import com.documentary.data.dataSource.LocalRepoDataSourceReadable
import com.documentary.data.entities.RepoEntity
import com.documentary.data.remote.GithubRemoteMediator
import dagger.Reusable
import javax.inject.Inject

/**
 * Repository class that works with local and remote data sources.
 */
@Reusable
class GithubRepository @Inject constructor(
    private val localRepoDataSource: LocalRepoDataSource,
    private val githubRemoteMediator: GithubRemoteMediator,
    private val dispatchers: AppCoroutineDispatchers
) : IGithubRepository {
    override fun getPagingSourceFactory(query: String): PagingSource<Int, RepoEntity> {
        val dbQuery = "%${query.replace(' ', '%')}%"
        return localRepoDataSource.read(LocalRepoDataSourceReadable.Params(dbQuery))

    }

    override fun getGithubRemoteMediator(query: String): GithubRemoteMediator =
        githubRemoteMediator(GithubRemoteMediator.Params(query))

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */
}