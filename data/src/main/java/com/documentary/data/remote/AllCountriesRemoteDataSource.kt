package com.documentary.data.remote

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.extensions.toResult
import com.documentary.data.entities.CountryEntity
import com.documentary.data.services.SampleService
import javax.inject.Inject

class AllCountriesRemoteDataSource @Inject constructor(
    private val service: SampleService
) {

    //    suspend fun getAllCountries() = service.getAllCountries().toResult()
//    suspend fun getAllInfo() = service.getAllInfo().toResult()
    suspend fun getAllCountries(): Result<List<CountryEntity>> =
        try {
            service.getAllCountries().toResult()
        } catch (t: Throwable) {
            ErrorResult(t)
        }

}