package com.documentary.home_feature

import com.documentary.domain.home.AllInfo

fun AllInfo.toAllInfoView() = AllInfoView(
    allId = allId,
    active = active,
    activePerOneMillion = activePerOneMillion,
    affectedCountries = affectedCountries,
    cases = cases,
    casesPerOneMillion = casesPerOneMillion,
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
    updated = updated
)
