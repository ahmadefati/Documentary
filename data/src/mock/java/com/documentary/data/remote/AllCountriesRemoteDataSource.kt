package com.documentary.data.remote

import android.util.Log
import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.data.entities.Success
import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.base.utils.AssetUtils
import com.documentary.data.entities.CountryEntity
import com.documentary.data.services.SampleService
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.json.JSONException
import javax.inject.Inject

/*
class AllCountriesRemoteDataSource @Inject constructor(
    private val service: SampleService
) {

    suspend fun getAllCountries(): Result<List<CountryEntity>> =
        try {
            service.getAllCountries().toResult()
        } catch (t: Throwable) {
            ErrorResult(t)
        }

}*/
class AllCountriesRemoteDataSource @Inject constructor(
    private val assetUtils: AssetUtils,
    private val moshi: Moshi,
    private val dispatchers: AppCoroutineDispatchers
) {


    suspend fun getAllCountries(): Result<List<CountryEntity>> =
        try {
            withContext(dispatchers.io) {
                delay(100)
                val listType =
                    Types.newParameterizedType(List::class.java, CountryEntity::class.java)
                val adapter: JsonAdapter<List<CountryEntity>> =
                    moshi.adapter<List<CountryEntity>>(listType)
                val jsonString = assetUtils.loadJSONFromAsset("country_list.json")
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
