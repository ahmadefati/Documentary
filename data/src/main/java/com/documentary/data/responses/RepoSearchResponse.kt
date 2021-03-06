package com.documentary.data.responses

import com.documentary.data.entities.repo.RepoEntity
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

/**
 * Data class to hold repo responses from searchRepo API calls.
 */
@JsonClass(generateAdapter = true)
data class RepoSearchResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<RepoEntity> = emptyList(),
    val nextPage: Int? = null
)