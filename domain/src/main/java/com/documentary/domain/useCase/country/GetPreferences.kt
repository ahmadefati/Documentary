package com.documentary.domain.useCase.country

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.documentary.base.utils.AppCoroutineDispatchers
import com.documentary.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<Unit, Preferences>() {
    override fun createObservable(params: Unit): Flow<Preferences> {
        return dataStore.data.flowOn(dispatchers.io)
    }

}