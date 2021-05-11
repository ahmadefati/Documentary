package com.documentary.domain.home

import com.documentary.data.entities.home.CountryInfoEntity

fun CountryInfoEntity.toCountryInfo() =
    CountryInfo(
        _id = _id,
        flag = flag,
        long = long,
        countryName = countryName
    )