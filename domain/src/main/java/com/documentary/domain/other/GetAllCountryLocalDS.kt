package com.documentary.domain.other

import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.data.entities.CountryEntity
import com.documentary.data.repos.HomeRepository
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCountryLocalDS @Inject constructor(
    private val repository: HomeRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<List<CountryEntity>>() {

//     fun createObservable(params: Params): Flow<List<CountryEntity>> {
//        return when(params.sortType) {
//            EnumType.ALL -> repository.getAllCountriesDb()
//        }.flowOn(dispatchers.io)
//    }

//    data class Params(
//        val sortType: EnumType
//    )

    override fun invoke(): Flow<List<CountryEntity>> {
        return repository.getAllCountriesDb()
    }

}

/* override suspend fun doWork(): Flow<List<CountryEntity>> {
     return withContext(dispatchers.io) {
         repository.getAllCountriesDb()
     }
 }
*/
