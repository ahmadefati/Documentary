package com.documentary.data.localDataSource

import androidx.room.withTransaction
import com.documentary.data.db.DocumentaryDatabase
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryEntity
import com.documentary.data.entities.CountryInfoEntity

import javax.inject.Inject

class HomeLocalDataSource @Inject constructor(
    private val docDb: DocumentaryDatabase
) {


    suspend fun insertAllInfo(data: AllInfoEntity?) {
        data?.let {
            docDb.allInfoDao().insertInfo(it)
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

    suspend fun getAllInfo() = docDb.allInfoDao().getInfo()

}