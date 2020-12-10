package com.documentary.home_feature

import com.androiddevs.data.entities.Country
import com.androiddevs.data.entities.Run
import com.androiddevs.view.UiError

data class ObjectsViewState(
    val runs: List<Run> = emptyList(),
    val countries: List<Country> = emptyList(),
    val error: UiError? = null,
    val refreshing: Boolean = false
)