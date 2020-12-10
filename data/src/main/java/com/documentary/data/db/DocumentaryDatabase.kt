package com.documentary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.documentary.data.db.Converters
import com.documentary.data.dao.AllInfoDao
import com.documentary.data.dao.CountryDao
import com.documentary.data.dao.CountryInfoDao
import com.documentary.data.entities.CountryEntity
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryInfoEntity

@Database(
    entities = [CountryEntity::class,AllInfoEntity::class,CountryInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DocumentaryDatabase : RoomDatabase() {
    abstract fun allInfoDao(): AllInfoDao
    abstract fun countryDao(): CountryDao
    abstract fun countryInfoDao(): CountryInfoDao
}