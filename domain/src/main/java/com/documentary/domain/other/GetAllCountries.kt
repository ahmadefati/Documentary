package com.documentary.domain.other

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.domain.SubjectInteractor
import com.documentary.data.entities.CountryEntity
import com.documentary.data.repos.HomeRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllCountries @Inject constructor(
    private val repository: HomeRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Int, Boolean>() {

    override fun createObservable(params: Int) = flow {
        emit(repository.getAllCountries())
    }.flowOn(dispatchers.io)
}