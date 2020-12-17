package com.documentary.home_feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.documentary.data.entities.CountryEntity
import com.documentary.domain.other.GetAllCountries
import com.documentary.domain.other.GetAllCountryLocalDS
import com.documentary.domain.other.GetAllInfo
import com.documentary.view.BaseViewModel
import com.documentary.view.ObservableLoadingCounter
import com.documentary.view.SnackbarManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel1 @ViewModelInject constructor(
    private val getAllCountries: GetAllCountries,
    private val getAllInfo: GetAllInfo,
    private val snackbarManager: SnackbarManager,
    private val getAllCountryLocalDS: GetAllCountryLocalDS
) : BaseViewModel<ObjectsViewState>(ObjectsViewState()) {


    private val loadingState = ObservableLoadingCounter()

    init {


        viewModelScope.launch {
            getAllCountries()
                .onStart {
                    loadingState.addLoader()
                }.onEach {
                    loadingState.removeLoader()
                }.collectLatest {
//                    copy(countries = it)
                    if (it) {
                        getAllCountryLocalDS().collectAndSetState { copy(countryEntity = it) }
                    }
                }
        }

        viewModelScope.launch {
            loadingState.observable.collectAndSetState { copy(refreshing = it) }
        }

    }

    fun selectCountry(asdasd: CountryEntity) {
//        TODO("Not yet implemented")
        Timber.i(asdasd.country)
    }

}