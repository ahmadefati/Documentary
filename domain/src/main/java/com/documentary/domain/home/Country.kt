package com.documentary.domain.home


data class Country(

    var id: Int? = null,
    var country: String = "",
    var active: Int? = 0,
    var activePerOneMillion: Double? = 0.0,
    var cases: Double? = 0.0,
    var casesPerOneMillion: Double? = 0.0,
    var continent: String? = "",
    var critical: Int? = 0,
    var criticalPerOneMillion: Double? = 0.0,
    var deaths: Int? = 0,
    var deathsPerOneMillion: Double? = 0.0,
    var oneCasePerPeople: Double? = 0.0,
    var oneDeathPerPeople: Double? = 0.0,
    var oneTestPerPeople: Double? = 0.0,
    var population: Int? = 0,
    var recovered: Int? = 0,
    var recoveredPerOneMillion: Double? = 0.0,
    var tests: Int? = 0,
    var testsPerOneMillion: Double? = 0.0,
    var todayCases: Int? = 0,
    var todayDeaths: Int? = 0,
    var todayRecovered: Int? = 0,
    var updated: Long? = 0,
    var countryInfo: CountryInfo? = null
)

data class CountryInfo(
    var _id: Int,
    var flag: String?,
    var long: Double,
    var countryName: String?
) {
    constructor() : this(
        0,
        "",
        0.0,
        ""
    )

}