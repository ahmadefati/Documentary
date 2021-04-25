package com.documentary.data.dao

import androidx.room.*
import com.documentary.data.entities.home.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: List<CountryEntity>)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    @Query("select * from country where country =:country")
    suspend fun getCountry(country: String): CountryEntity

    @Query("select * from country")
    fun getAllCountries(): Flow<List<CountryEntity>>

    @Query("Delete FROM country where id=:id")
    suspend fun deleteCountry(id: Int)

    @Query("Delete FROM country")
    suspend fun deleteCountryAll()

}