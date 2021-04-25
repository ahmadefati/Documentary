package com.documentary.data.repos

import com.documentary.base.data.entities.Success
import com.documentary.data.entities.home.AllInfoEntity
import com.documentary.data.localDataSource.CountryInfoLocalDataSource
import com.documentary.data.remote.AllInfoRemoteDataSource
import javax.inject.Inject

class GetAllInfoRepository @Inject constructor(
    private val localDs: CountryInfoLocalDataSource,
    private val allInfoRemote: AllInfoRemoteDataSource
) {

    /*suspend fun getAllInfo() = when (val result = AllInfoRemote.getAllInfo()) {
        is Success -> {
//            localDs.insertCountries(result.data)
            true
        }
        is ErrorResult -> {
            throw result.throwable
        }
        else -> false
    }*/

    suspend fun getAllInfo(): AllInfoEntity {
        val result = allInfoRemote.getAllInfo() as Success
        return result.data
    }


}