package com.documentary.data.localDataSource

import com.documentary.data.dao.AllInfoDao
import com.documentary.data.entities.AllInfoEntity
import javax.inject.Inject

class AllInfoDataSource @Inject constructor(
    private val allInfoDao: AllInfoDao
) {

    suspend fun insertAllInfo(data: AllInfoEntity?) {
        data?.let {
            allInfoDao.insertInfo(it)
        }
    }

    suspend fun getAllInfo(): AllInfoEntity = allInfoDao.getInfo()

}