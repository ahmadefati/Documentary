package com.documentary.home_feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryEntity
import com.documentary.domain.useCase.country.GetAllCountries
import com.documentary.domain.useCase.country.GetAllInfo
import com.documentary.view.BaseViewModel
import com.documentary.view.ObservableLoadingCounter
import com.documentary.view.SnackbarManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(
    private val getAllCountries: GetAllCountries,
    private val getAllInfo: GetAllInfo,
    private val snackbarManager: SnackbarManager

) : BaseViewModel<ObjectsViewState>(ObjectsViewState()) {

    internal var countries: List<CountryEntity>? = null
    private val loadingState = ObservableLoadingCounter()


    val countryList: Flow<List<CountryEntity>>
        get() = getAllCountries.observe()

    val getInfoEntity: Flow<AllInfoEntity>
        get() = getAllInfo.observe()

    init {

        viewModelScope.launch {
            getInfoEntity
                .distinctUntilChanged()
                .collectAndSetState { copy(allInfoEntity = it) }
        }

        viewModelScope.launch {
            countryList
                .distinctUntilChanged()
                .collectAndSetState {
                    copy(countryEntity = it)
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

    fun getAllCountries() {
        getAllCountries(Unit)
        getAllInfo(Unit)
    }

    fun collectCountryList(country: List<CountryEntity>) {
        viewModelScope.launch {
            countryList
                .distinctUntilChanged()
                .collectAndSetState {
                    copy(countryEntity = country)
                }
        }

    }

}