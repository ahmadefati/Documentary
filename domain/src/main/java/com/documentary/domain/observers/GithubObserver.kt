package com.documentary.domain.observers


import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.documentary.data.entities.Repo
import com.documentary.data.repos.GithubRepository
import com.documentary.domain.PagingInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubObserver @Inject constructor(
    private val githubRepository: GithubRepository
) : PagingInteractor<GithubObserver.Params, Repo>() {

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */

    override fun createObservable(params: Params): Flow<PagingData<Repo>> {
        Log.d("GithubRepository", "New query: ${params.query}")

        // appending '%' so we can allow other characters to be before and after the query string
        val dbQuery = "%${params.query.replace(' ', '%')}%"
        val pagingSourceFactory = { githubRepository.getPagingSourceFactory(dbQuery) }

        return Pager(
            config = params.config,
            remoteMediator = githubRepository.getGithubRemoteMediator(params.query),
            pagingSourceFactory = pagingSourceFactory
        ).flow


    }

    data class Params(
        override val config: PagingConfig,
        override val query: String

    ) : Parameters<Repo>

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }


}