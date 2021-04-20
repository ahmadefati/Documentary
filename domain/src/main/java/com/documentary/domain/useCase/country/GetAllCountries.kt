package com.documentary.domain.useCase.country

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.repos.country.AllCountriesRepository
import com.documentary.domain.SubjectInteractor
import com.documentary.domain.home.Country
import com.documentary.domain.home.toCountry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllCountries @Inject constructor(
    private val repository: AllCountriesRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Unit, List<Country>>() {
    override fun createObservable(params: Unit): Flow<List<Country>> {
        return flow {
            emit(repository.getAllCountries().map { it.toCountry() })
        }.flowOn(dispatchers.io)
    }

}
