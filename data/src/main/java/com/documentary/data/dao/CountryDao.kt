package com.documentary.data.dao

import androidx.room.*
import com.documentary.data.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountry(countryEntity: List<CountryEntity>)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    @Query("select * from country where country =:country")
    suspend fun getCountry(country: String): CountryEntity

    @Query("select * from country")
    fun getAllCountries(): Flow<List<CountryEntity>>

}