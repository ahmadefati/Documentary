package com.documentary.data.localDataSource

import com.documentary.data.dao.AllInfoDao
import com.documentary.data.db.DocumentaryDatabase
import javax.inject.Inject

class HomeLocalDataSource @Inject constructor(
    private val docDb: DocumentaryDatabase,
    private val allInfoDao: AllInfoDao
) {

/*
    suspend fun insertAllInfo(data: AllInfoEntity?) {
        data?.let {
            allInfoDao.insertInfo(it)
        }
    }

    suspend fun insertCountries(data: List<CountryEntity>?) {
        docDb.withTransaction {
            data?.let {
                docDb.countryDao().insertCountry(data)
                data.forEach { country ->
                    country.countryInfo?.let { infoEntity ->
                        insertCountryInfo(
                            country.country,
                            infoEntity
                        )
                    }
                }
            }
        }
    }

    private suspend fun insertCountryInfo(country: String, countyInfo: CountryInfoEntity) {
        countyInfo.countryName = country
        docDb.countryInfoDao().insertCountryInfo(countyInfo)
    }

    fun getAllCountries() = docDb.countryDao().getAllCountries()

    suspend fun getAllInfo() = allInfoDao.getInfo()*/

}