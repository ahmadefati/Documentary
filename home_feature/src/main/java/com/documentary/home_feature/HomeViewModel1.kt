package com.documentary.home_feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.documentary.data.entities.CountryEntity
import com.documentary.domain.useCase.country.GetAllCountries
import com.documentary.domain.useCase.country.GetAllCountryLocalDS
import com.documentary.domain.useCase.country.GetAllInfo
import com.documentary.view.BaseViewModel
import com.documentary.view.ObservableLoadingCounter
import com.documentary.view.SnackbarManager
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel1 @ViewModelInject constructor(
    private val getAllCountries: GetAllCountries,
    private val getAllInfo: GetAllInfo,
    private val snackbarManager: SnackbarManager,
    private val getAllCountryLocalDS: GetAllCountryLocalDS
) : BaseViewModel<ObjectsViewState>(ObjectsViewState()) {

    internal lateinit var countries: List<CountryEntity>
    private val loadingState = ObservableLoadingCounter()

    init {


        /* viewModelScope.launch {
             getAllCountries()
                 .onStart {
                     loadingState.addLoader()
                 }.onEach {
                     loadingState.removeLoader()
                 }.collectAndSetState {
                     copy(countryEntity = it)
                 }
         }*/

        viewModelScope.launch {
            loadingState.observable.collectAndSetState { copy(refreshing = it) }
        }

    }

    fun selectCountry(asdasd: CountryEntity) {
//        TODO("Not yet implemented")
        Timber.i(asdasd.country)
    }

}