package com.documentary.data.repos.country

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Success
import com.documentary.data.entities.CountryEntity
import com.documentary.data.localDataSource.CountryInfoLocalDataSource
import com.documentary.data.remote.AllCountriesRemoteDataSource
import javax.inject.Inject

class AllCountriesRepository @Inject constructor(
    private val localDs: CountryInfoLocalDataSource,
    private val allCountriesRemote: AllCountriesRemoteDataSource

) {
    suspend fun getAllCountries(): List<CountryEntity> {
        return when (val result = allCountriesRemote.getAllCountries()) {
            is Success -> {
//                localDs.insertCountries(result.data)
                result.data
            }
            is ErrorResult -> {
                result.throwable
                emptyList()

            }
            else -> emptyList()

        }
    }

    suspend fun getAllCountriesDb() = localDs.getAllCountries()

}