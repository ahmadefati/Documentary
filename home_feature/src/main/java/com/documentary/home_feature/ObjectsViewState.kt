package com.documentary.home_feature


import com.documentary.data.entities.AllInfoEntity
import com.documentary.data.entities.CountryEntity
import com.documentary.view.UiError

data class ObjectsViewState(
    val allInfoEntity: AllInfoEntity? = null,
    val countryEntity: List<CountryEntity> = emptyList(),
    val error: UiError? = null,
    val refreshing: Boolean = false
)