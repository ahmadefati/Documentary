package com.documentary.home_feature

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.documentary.base.Constants

import com.androiddevs.view.BaseViewModel
import com.androiddevs.view.ObservableLoadingCounter
import com.androiddevs.view.SnackbarManager
import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryEntity
import com.documentary.domain.other.GetAllCountries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel1 @ViewModelInject constructor(
    private val getAllCountries: GetAllCountries,
    private val snackbarManager: SnackbarManager
) : BaseViewModel<ObjectsViewState>(ObjectsViewState()) {
    private val loadingState = ObservableLoadingCounter()

    init {

        viewModelScope.launch {
            getAllCountries.observe()
                .onStart {
                    loadingState.addLoader()
                }.onEach {
                    loadingState.removeLoader()
                }.collectAndSetState {
                    copy(countries = it)
                }
        }

        viewModelScope.launch {
            loadingState.observable.collectAndSetState { copy(refreshing = it) }
        }

    }
    private var requestCount = 1
    fun clickOnCountry() {
        getAllCountries(requestCount++)
    }


    private var _allInfoResult = MutableLiveData<Result<AllInfoEntity>>()
    val allInfoResult: LiveData<Result<AllInfoEntity>> get() = _allInfoResult

    private var _allCountriesResult = MutableLiveData<Result<List<CountryEntity>>>()
    val allCountriesResult: LiveData<Result<List<CountryEntity>>> get() = _allCountriesResult

    private var _allCountriesDbResult = MutableLiveData<List<CountryEntity>>()
    val allCountriesDbResult: LiveData<List<CountryEntity>> get() = _allCountriesDbResult

    private var _allInfoDbResult = MutableLiveData<AllInfoEntity>()
    val allInfoDbResult: LiveData<AllInfoEntity> get() = _allInfoDbResult

    fun getAllInfoDb() {
        viewModelScope.launch(Dispatchers.IO) {
            _allInfoDbResult.postValue(homeRepository.getAllInfoDb())
        }
    }

    fun getAllCountriesDb() {
        viewModelScope.launch(Dispatchers.IO) {
            _allCountriesDbResult.postValue(homeRepository.getAllCountriesDb())
        }
    }

    fun getAllInfo() {
        _allInfoResult.value = Resource.loading(null)

        viewModelScope.launch(Dispatchers.IO) {
            _allInfoResult.postValue(homeRepository.getAllInfo())
        }
    }

    fun getAllCountries() {
        _allCountriesResult.value = Resource.loading(null)

        viewModelScope.launch(Dispatchers.IO) {
            _allCountriesResult.postValue(homeRepository.getAllCountries())
        }
    }

}