package com.documentary.app.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.documentary.base.PreferenceKeys.KEY_NAME
import com.documentary.base.PreferenceKeys.KEY_TOKEN
import com.documentary.domain.other.GetPreferences
import com.documentary.view.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val getPreferences: GetPreferences
) : BaseViewModel<MainViewState>(MainViewState()) {

    init {
        viewModelScope.launch {
            getPreferences().collectAndSetState {
                copy(
                    name = it[KEY_NAME]?.toString(),
                    token = it[KEY_TOKEN]?.toString()
                )
            }
        }
    }

}