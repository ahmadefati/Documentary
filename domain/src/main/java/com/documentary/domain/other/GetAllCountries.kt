package com.documentary.domain.other

import com.documentary.base.data.entities.Result
import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.entities.CountryEntity
import com.documentary.data.repos.country.CountryStore
import com.documentary.data.repos.country.HomeRepository
import com.documentary.data.view.fetchCollection
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllCountries @Inject constructor(
    private val repository: HomeRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<List<CountryEntity>>() {

    /*override fun invoke(): Flow<List<CountryEntity>> = flow {
        emit(countryStore.fetchCollection(1, true))
    }.flowOn(dispatchers.io)*/
    override fun invoke(): Flow<List<CountryEntity>> = flow {
        emit(repository.getAllCountries())
    }.flowOn(dispatchers.io)
}
