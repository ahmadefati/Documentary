package com.documentary.data.localDataSource

import com.documentary.data.dao.CountryDao
import com.documentary.data.entities.home.CountryEntity
import javax.inject.Inject

class CountryInfoLocalDataSource @Inject constructor(
    private val countryDao: CountryDao,

    ) {

    suspend fun getAllCountries() = countryDao.getAllCountries()

    suspend fun insertCountries(data: List<CountryEntity>?) {
        data?.let {
            countryDao.insertCountry(data)

        }
    }

}