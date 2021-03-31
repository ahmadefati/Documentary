package com.documentary.data.remote

import android.util.Log
import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.data.entities.Success
import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.base.utils.AssetUtils
import com.documentary.data.dataSource.iDataSource.Readable
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryEntity
import com.documentary.data.entities.RepoRequest
import com.documentary.data.responses.RepoSearchResponse
import com.documentary.data.services.RepoService
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.json.JSONException
import retrofit2.Response
import javax.inject.Inject

class RemoteRepoDataSource @Inject constructor(
    private val assetUtils: AssetUtils,
    private val moshi: Moshi,
    private val dispatchers: AppCoroutineDispatchers
) : RemoteRepoDataSourceReadable {
    override suspend fun read(input: RepoRequest): Result<RepoSearchResponse> =
        try {
            withContext(dispatchers.io) {
                delay(100)
                val adapter: JsonAdapter<RepoSearchResponse> = moshi.adapter<RepoSearchResponse>(
                    RepoSearchResponse::class.java
                )
                val jsonString = assetUtils.loadJSONFromAsset("Repo.json")

                val result = adapter.fromJson(jsonString)

                if (result != null)
                    Success(result)
                else
                    ErrorResult(JSONException(""))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
            ErrorResult(e)
        }

}
typealias RemoteRepoDataSourceReadable =
        Readable.Suspendable.IO<RepoRequest, Result<RepoSearchResponse>>