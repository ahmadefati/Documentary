package com.documentary.domain.home

import com.documentary.data.entities.home.CountryEntity

fun CountryEntity.toCountry() = Country(
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
    countryInfo = countryInfo?.toCountryInfo()
)