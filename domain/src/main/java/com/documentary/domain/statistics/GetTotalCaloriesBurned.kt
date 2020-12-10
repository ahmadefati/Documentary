package com.androiddevs.domain.statistics

import com.androiddevs.base.utils.AppCoroutineDispatchers
import com.androiddevs.data.repos.MainRepository
import com.androiddevs.domain.SuspendingWorkInteractor
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTotalCaloriesBurned @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SuspendingWorkInteractor<Unit, String>() {

    override suspend fun doWork(params: Unit): String {
        return withContext(dispatchers.io) {
            repository.getTotalCaloriesBurned().let {
                "${it}Kcal"
            }
        }
    }
}