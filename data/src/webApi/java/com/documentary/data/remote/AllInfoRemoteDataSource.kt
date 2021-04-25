package com.documentary.data.remote

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Result
import com.documentary.base.extensions.toResult
import com.documentary.data.entities.home.AllInfoEntity
import com.documentary.data.services.SampleService
import javax.inject.Inject

class AllInfoRemoteDataSource @Inject constructor(
    private val service: SampleService
) {

    suspend fun getAllInfo(): Result<AllInfoEntity> =
        try {
            service.getAllInfo().toResult()
        } catch (t: Throwable) {
            ErrorResult(t)
        }

}