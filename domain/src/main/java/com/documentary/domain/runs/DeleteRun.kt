package com.androiddevs.domain.runs

import com.androiddevs.base.utils.AppCoroutineDispatchers
import com.androiddevs.data.entities.Run
import com.androiddevs.data.repos.MainRepository
import com.androiddevs.domain.Interactor
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteRun @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: AppCoroutineDispatchers
) : Interactor<Run>() {

    override suspend fun doWork(params: Run) {
        withContext(dispatchers.io) {
            repository.deleteRun(params)
        }
    }
}