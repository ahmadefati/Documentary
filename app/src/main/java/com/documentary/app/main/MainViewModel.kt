package com.documentary.app.main

import androidx.datastore.preferences.core.Preferences
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.documentary.base.PreferenceKeys.KEY_NAME
import com.documentary.base.PreferenceKeys.KEY_TOKEN
import com.documentary.domain.useCase.country.GetPreferences
import com.documentary.view.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val getPreferences: GetPreferences
) : BaseViewModel<MainViewState>(MainViewState()) {

    val pagedList: Flow<Preferences>
        get() = getPreferences.observe()

    init {
        getPreferences(Unit)
        viewModelScope.launch {
            pagedList.collectAndSetState {
                copy(
                    name = it[KEY_NAME]?.toString(),
                    token = it[KEY_TOKEN]?.toString()
                )
            }
        }
    }


}