package com.documentary.data.remote

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.data.entities.Success
import com.documentary.base.utils.AssetUtils
import com.documentary.data.entities.CountryEntity
import com.documentary.data.services.SampleService
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
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
    private val service: SampleService,
    private val assetUtils: AssetUtils,
    private val moshi: Moshi
) {


    suspend fun getAllCountries(): Result<List<CountryEntity>> =
        try {

            val listType = Types.newParameterizedType(List::class.java, CountryEntity::class.java)
            val adapter: JsonAdapter<List<CountryEntity>> = moshi.adapter(listType)
            val result = adapter.fromJson(assetUtils.loadJSONFromAsset("country_list.json"))
            if (result != null)
                Success(result)
            else
                ErrorResult(JSONException(""))

        } catch (e: JSONException) {
            e.printStackTrace()
            ErrorResult(e)
        }

}
