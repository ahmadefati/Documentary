package com.documentary.data.repos

import com.documentary.base.data.entities.ErrorResult
import com.documentary.base.data.entities.Success
import com.documentary.data.localDataSource.HomeLocalDataSource
import com.documentary.data.remote.MainDataSource
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val localDs: HomeLocalDataSource,
    private val remote: MainDataSource
) {
    suspend fun getAllCountries() = when (val result = remote.getAllCountries()) {
        is Success -> {
            localDs.insertCountries(result.data)
            true
        }
        is ErrorResult -> {
            throw result.throwable

        }
        else -> false
    }


    suspend fun getAllInfoDb() = localDs.getAllInfo()

    fun getAllCountriesDb() = localDs.getAllCountries()

    suspend fun getAllInfo() = when (val result = remote.getAllInfo()) {
        is Success -> {
            localDs.insertAllInfo(result.data)
            true
        }
        is ErrorResult -> {
            throw result.throwable
        }
        else -> false
    }

    /* suspend fun getAllInfo(): Resource<AllInfoEntity> {
     var response = Resource<AllInfoEntity>(Status.ERROR, null, null)

     if (NetworkHelper.isOnline(MyApp.app)) {

         val request = homeRemoteDataSource.getAllInfo()

         if (request.status == Status.SUCCESS) {

             response = Resource.success(request.data)
             homeLocalDataSource.insertAllInfo(request.data)

         } else if (request.status == Status.ERROR) {
             request.message?.let {
                 response = Resource.error(it, null)
             }
         }

     }

     return response

 }

 suspend fun getAllCountries(): Resource<AllCountriesResponse> {
     var response = Resource<AllCountriesResponse>(Status.ERROR, null, null)

     if (NetworkHelper.isOnline(MyApp.app)) {

         val request = homeRemoteDataSource.getAllCountries()

         if (request.status == Status.SUCCESS) {

             response = Resource.success(request.data)
             homeLocalDataSource.insertCountries(request.data)

         } else if (request.status == Status.ERROR) {
             request.message?.let {
                 response = Resource.error(it, null)
             }
         }

     }

     return response

 }*/


}