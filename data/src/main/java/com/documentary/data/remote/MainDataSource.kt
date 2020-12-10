package com.documentary.data.remote


import com.documentary.base.extensions.toResult
import com.documentary.data.services.SampleService
import javax.inject.Inject

class MainDataSource @Inject constructor(
    private val service: SampleService
) {

    suspend fun getAllCountries() = service.getAllCountries().toResult()
    suspend fun getAllInfo() = service.getAllInfo().toResult()

}