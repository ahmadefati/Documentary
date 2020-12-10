package com.documentary.domain.other

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.repos.HomeRepository
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllInfo @Inject constructor(
    private val repository: HomeRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Int, Boolean>() {

    override fun createObservable(params: Int) = flow {
        emit(repository.getAllInfo())
    }.flowOn(dispatchers.io)
}