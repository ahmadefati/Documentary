package com.documentary.domain.useCase.country

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.repos.GetAllInfoRepository
import com.documentary.domain.SubjectInteractor
import com.documentary.domain.home.AllInfo
import com.documentary.domain.home.toAllInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllInfo @Inject constructor(
    private val repository: GetAllInfoRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Unit, AllInfo>() {
    override fun createObservable(params: Unit): Flow<AllInfo> = flow {
        emit(repository.getAllInfo().toAllInfo())
    }.flowOn(dispatchers.io)
}