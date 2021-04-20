package com.documentary.domain.repo

data class RepoRequest(
    val url: String,
    val query: String,
    val pageNumber: Int,
    val pageSize: Int
)