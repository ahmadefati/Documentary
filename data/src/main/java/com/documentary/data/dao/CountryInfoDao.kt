package com.documentary.data.dao

import androidx.room.*
import com.documentary.data.entities.CountryInfoEntity

@Dao
interface CountryInfoDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountryInfo(countryInfoEntity: CountryInfoEntity)

    @Query("select * from countryInfo where countryName =:country")
    suspend fun getCountryInfo(country: String): CountryInfoEntity

}