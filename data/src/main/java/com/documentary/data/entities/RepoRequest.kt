package com.documentary.data.entities

data class RepoRequest(
    val url: String,
    val query: String,
    val pageNumber: Int,
    val pageSize: Int
)