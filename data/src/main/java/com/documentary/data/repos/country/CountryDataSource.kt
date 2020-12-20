package com.documentary.data.repos.country

import com.documentary.base.extensions.toResult
import com.documentary.data.services.SampleService
import javax.inject.Inject

class CountryDataSource @Inject constructor(private val service: SampleService) {
    suspend fun getAllCountries() = service.getAllCountries().toResult()

}