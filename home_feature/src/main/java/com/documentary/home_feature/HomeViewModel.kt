package com.documentary.home_feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.documentary.domain.home.AllInfo
import com.documentary.domain.home.Country
import com.documentary.domain.useCase.country.GetAllCountries
import com.documentary.domain.useCase.country.GetAllInfo
import com.documentary.view.BaseViewModel
import com.documentary.view.ObservableLoadingCounter
import com.documentary.view.SnackbarManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getAllCountries: GetAllCountries,
    private val getAllInfo: GetAllInfo,
    private val snackbarManager: SnackbarManager

) : BaseViewModel<ObjectsViewState>(ObjectsViewState()) {

    internal var countries: List<CountryView>? = null
    private val loadingState = ObservableLoadingCounter()


    val countryList: Flow<List<Country>>
        get() = getAllCountries.observe()

    val getInfo: Flow<AllInfo>
        get() = getAllInfo.observe()

    init {

        viewModelScope.launch {
            getInfo
                .distinctUntilChanged()
                .collectAndSetState { copy(allInfoView = it.toAllInfoView()) }
        }

        viewModelScope.launch {
            countryList
                .distinctUntilChanged()
                .collectAndSetState {
                    copy(countryView = it.map { it.toCountryView() })
                }
        }

        viewModelScope.launch {
            loadingState.observable.collectAndSetState { copy(refreshing = it) }
        }

    }

    fun getAllCountries() {
        getAllCountries(Unit)
        getAllInfo(Unit)
    }

}