package com.documentary.data.entities

data class RepoRequestModel(
    val url: String,
    val query: String,
    val pageNumber: Int,
    val pageSize: Int
)