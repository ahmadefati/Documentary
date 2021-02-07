package com.documentary.data.dataSource

import com.documentary.data.dataSource.iDataSource.Readable
import com.documentary.data.entities.RepoRequest
import com.documentary.data.responses.RepoSearchResponse
import com.documentary.data.services.RepoService
import retrofit2.Response
import javax.inject.Inject

class RemoteRepoDataSource @Inject constructor(
    private val service: RepoService
//    private val dispatchers: AppCoroutineDispatchers
) : RemoteRepoDataSourceReadable {
    override suspend fun read(input: RepoRequest): Response<RepoSearchResponse> {
//        withContext(dispatchers.io) {
        return service.searchRepos(input.url, input.query, input.pageNumber, input.pageSize)
//        }
    }

}

/*interface RemoteRepoDataSourceReadable :
    Readable.Suspendable.IO<RepoRequest, RepoSearchResponse> {
    data class Params(val url: String, val query: String,val pageNumber:Int,val pageSize: Int)
}*/
typealias RemoteRepoDataSourceReadable =
        Readable.Suspendable.IO<RepoRequest, Response<RepoSearchResponse>>