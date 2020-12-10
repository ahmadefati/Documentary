package com.documentary.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countryInfo")
data class CountryInfoEntity(
    @PrimaryKey var _id: Int,
    var flag: String?,
    var long: Double,
    var countryName: String
) {
    constructor() : this(
        0,
        "",
        0.0,
        ""
    )

}