package com.androiddevs.domain.tracking

import com.documentary.base.utils.AppCoroutineDispatchers

import com.androiddevs.data.repos.MainRepository

import com.documentary.domain.Interactor
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertRun @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: AppCoroutineDispatchers
) /*: Interactor<Run>() {

    override suspend fun doWork(params: Run) {
        withContext(dispatchers.io) {
            repository.insertRun(params)
        }
    }

}*/