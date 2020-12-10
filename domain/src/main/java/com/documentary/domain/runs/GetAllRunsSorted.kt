package com.androiddevs.domain.runs

import com.androiddevs.base.utils.AppCoroutineDispatchers
import com.androiddevs.data.entities.Run
import com.androiddevs.data.repos.MainRepository
import com.androiddevs.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllRunsSorted @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<GetAllRunsSorted.Params, List<Run>>() {

    override fun createObservable(params: Params): Flow<List<Run>> {
        return when(params.sortType) {
            SortType.DATE -> repository.getAllRunsSortedByDate()
            SortType.AVG_SPEED -> repository.getAllRunsSortedByAvgSpeed()
            SortType.CALORIES_BURNED -> repository.getAllRunsSortedByCaloriesBurned()
            SortType.RUNNING_TIME -> repository.getAllRunsSortedByTimeInMillis()
            SortType.DISTANCE -> repository.getAllRunsSortedByDistance()
        }.flowOn(dispatchers.io)
    }

    data class Params(
        val sortType: SortType
    )

}