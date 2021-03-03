package com.documentary.domain.useCase.country

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.repos.GetAllInfoRepository
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllInfo @Inject constructor(
    private val repository: GetAllInfoRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Unit, AllInfoEntity>() {
    override fun createObservable(params: Unit): Flow<AllInfoEntity> = flow {
        emit(repository.getAllInfo())
    }.flowOn(dispatchers.io)
}