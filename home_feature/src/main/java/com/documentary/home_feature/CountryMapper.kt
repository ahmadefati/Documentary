package com.documentary.home_feature

import com.documentary.domain.home.Country

fun Country.toCountryView() = CountryView(
    id = id,
    country = country,
    active = active,
    activePerOneMillion = activePerOneMillion,
    cases = cases,
    casesPerOneMillion = casesPerOneMillion,
    continent = continent,
    critical = critical,
    criticalPerOneMillion = criticalPerOneMillion,
    deaths = deaths,
    deathsPerOneMillion = deathsPerOneMillion,
    oneCasePerPeople = oneCasePerPeople,
    oneDeathPerPeople = oneDeathPerPeople,
    oneTestPerPeople = oneTestPerPeople,
    population = population,
    recovered = recovered,
    recoveredPerOneMillion = recoveredPerOneMillion,
    tests = tests,
    testsPerOneMillion = testsPerOneMillion,
    todayCases = todayCases,
    todayDeaths = todayDeaths,
    todayRecovered = todayRecovered,
    updated = updated,
    countryInfo = countryInfo?.toCountryInfoView()
)