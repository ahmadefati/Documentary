package com.documentary.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "countryInfo")
@JsonClass(generateAdapter = true)
data class CountryInfoEntity(
    @PrimaryKey var _id: Int,
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