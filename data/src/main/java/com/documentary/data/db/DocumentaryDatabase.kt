package com.documentary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.documentary.data.dao.AllInfoDao
import com.documentary.data.dao.CountryDao
import com.documentary.data.dao.repo.RemoteKeysDao
import com.documentary.data.dao.repo.RepoDao
import com.documentary.data.entities.*

@Database(
    entities = [CountryEntity::class, AllInfoEntity::class, CountryInfoEntity::class, Repo::class, RemoteKeys::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DocumentaryDatabase : RoomDatabase() {
    abstract fun allInfoDao(): AllInfoDao
    abstract fun countryDao(): CountryDao

    //    abstract fun countryInfoDao(): CountryInfoDao
    abstract fun reposDao(): RepoDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}