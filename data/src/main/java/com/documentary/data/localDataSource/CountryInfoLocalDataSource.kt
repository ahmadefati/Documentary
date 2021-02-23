package com.documentary.data.localDataSource

import com.documentary.data.dao.CountryDao
import com.documentary.data.entities.CountryEntity
import javax.inject.Inject

class CountryInfoLocalDataSource @Inject constructor(
    private val countryDao: CountryDao,

    ) {

    suspend fun getAllCountries() = countryDao.getAllCountries()


    suspend fun insertCountries(data: List<CountryEntity>?) {
//        docDb.withTransaction {
        data?.let {
            countryDao.insertCountry(data)
            /*data.forEach { country ->
                country.countryInfo?.let { infoEntity ->
                    insertCountryInfo(
                        country.country,
                        infoEntity
                    )
                }
            }*/
        }
//        }
    }

    /*  private suspend fun insertCountryInfo(country: String, countyInfo: CountryInfoEntity) {
          countyInfo.countryName = country
          docDb.countryInfoDao().insertCountryInfo(countyInfo)
      }*/


}