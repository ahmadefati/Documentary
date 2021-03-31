package com.documentary.data.remote

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.extensions.toResult
import com.documentary.data.dataSource.iDataSource.Readable
import com.documentary.data.entities.RepoRequest
import com.documentary.data.responses.RepoSearchResponse
import com.documentary.data.services.RepoService
import javax.inject.Inject

class RemoteRepoDataSource @Inject constructor(
    private val service: RepoService
) : RemoteRepoDataSourceReadable {
    override suspend fun read(input: RepoRequest): Result<RepoSearchResponse> =
        try {
            service.searchRepos(input.url, input.query, input.pageNumber, input.pageSize).toResult()
        } catch (t: Throwable) {
            ErrorResult(t)
        }

}
typealias RemoteRepoDataSourceReadable =
        Readable.Suspendable.IO<RepoRequest, Result<RepoSearchResponse>>