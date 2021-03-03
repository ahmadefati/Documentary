package com.documentary.domain.useCase.country

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.entities.CountryEntity
import com.documentary.data.repos.country.AllCountriesRepository
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllCountries @Inject constructor(
    private val repository: AllCountriesRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Unit, List<CountryEntity>>() {
    override fun createObservable(params: Unit): Flow<List<CountryEntity>> {
        return flow {
            emit(repository.getAllCountries())
        }.flowOn(dispatchers.io)
    }

    /*override fun invoke(): Flow<List<CountryEntity>> = flow {
        emit(countryStore.fetchCollection(1, true))
    }.flowOn(dispatchers.io)*/
    /*override fun invoke(): Flow<List<CountryEntity>> = flow {
        emit(repository.getAllCountries())
    }.flowOn(dispatchers.io)*/

}
