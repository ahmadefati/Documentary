package com.documentary.domain.other

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.repos.HomeRepository
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllCountries @Inject constructor(
    private val repository: HomeRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Boolean>() {

    override fun invoke(): Flow<Boolean> = flow {
        emit(repository.getAllCountries())
    }.flowOn(dispatchers.io)
}