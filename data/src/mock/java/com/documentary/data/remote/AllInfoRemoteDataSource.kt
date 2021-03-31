package com.documentary.data.remote

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.data.entities.Success
import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.base.utils.AssetUtils
import com.documentary.data.entities.AllInfoEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.json.JSONException
import javax.inject.Inject

class AllInfoRemoteDataSource @Inject constructor(
    private val assetUtils: AssetUtils,
    private val moshi: Moshi,
    private val dispatchers: AppCoroutineDispatchers
) {

    suspend fun getAllInfo(): Result<AllInfoEntity> =
        /*try {
            service.getAllInfo().toResult()
        } catch (t: Throwable) {
            ErrorResult(t)
        }*/
        try {
            withContext(dispatchers.io) {
                delay(100)
                val adapter: JsonAdapter<AllInfoEntity> = moshi.adapter<AllInfoEntity>(
                    AllInfoEntity::class.java
                )
                val jsonString = assetUtils.loadJSONFromAsset("AllInfo.json")
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