package com.documentary.app.ui.event

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.documentary.base.EventManager
import com.documentary.base.PreferenceKeys.KEY_TOKEN
import com.documentary.base.utils.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppEventManager @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val dispatchers: AppCoroutineDispatchers
) : EventManager {
    override fun unAuthorizedDetected() {
        CoroutineScope(dispatchers.io).launch {
            dataStore.edit {
                it[KEY_TOKEN] = ""
            }
        }
    }
}