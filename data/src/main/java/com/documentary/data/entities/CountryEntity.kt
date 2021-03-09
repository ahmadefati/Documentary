package com.documentary.data.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass


@Entity(tableName = "country")
@JsonClass(generateAdapter = true)
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
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
    @Ignore var countryInfo: CountryInfoEntity? = null
)