package com.documentary.base

import androidx.datastore.preferences.core.preferencesKey

object PreferenceKeys {
    val KEY_NAME = preferencesKey<String>("KEY_NAME")
    val KEY_IS_FIRST_OPEN = preferencesKey<Boolean>("KEY_IS_FIRST_OPEN")
    val KEY_TOKEN = preferencesKey<String>("KEY_TOKEN")
}