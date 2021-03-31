package com.documentary.data.localDataSource

import com.documentary.data.dao.AllInfoDao
import com.documentary.data.db.DocumentaryDatabase
import javax.inject.Inject

class HomeLocalDataSource @Inject constructor(
    private val docDb: DocumentaryDatabase,
    private val allInfoDao: AllInfoDao
) {

}