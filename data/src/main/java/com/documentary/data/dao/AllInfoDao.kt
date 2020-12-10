package com.documentary.data.dao

import androidx.room.*
import com.documentary.data.entities.AllInfoEntity

@Dao
interface AllInfoDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInfo(allInfoEntity: AllInfoEntity)

    @Query("select * from allInfo")
    suspend fun getInfo(): AllInfoEntity
}