package com.documentary.data.services

import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryEntity
import retrofit2.Response
import retrofit2.http.GET

interface SampleService {

    @GET("countries")
    suspend fun getAllCountries(): Response<List<CountryEntity>>

    @GET("all")
    suspend fun getAllInfo(): Response<AllInfoEntity>

}