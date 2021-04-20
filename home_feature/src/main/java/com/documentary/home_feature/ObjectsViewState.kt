package com.documentary.home_feature


import com.documentary.view.UiError

data class ObjectsViewState(
    val allInfoView: AllInfoView? = null,
    val countryView: List<CountryView> = emptyList(),
    val error: UiError? = null,
    val refreshing: Boolean = false
)