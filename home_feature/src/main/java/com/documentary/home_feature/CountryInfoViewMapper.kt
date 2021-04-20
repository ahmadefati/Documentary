package com.documentary.home_feature


import com.documentary.domain.home.CountryInfo

fun CountryInfo.toCountryInfoView() =
    CountryInfoView(
        _id, flag, long, countryName
    )