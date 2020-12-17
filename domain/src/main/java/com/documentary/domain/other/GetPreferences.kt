package com.documentary.domain.other

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
) : SubjectInteractor<Preferences>() {

    override fun invoke(): Flow<Preferences> {
        return dataStore.data.flowOn(dispatchers.io)
    }

}