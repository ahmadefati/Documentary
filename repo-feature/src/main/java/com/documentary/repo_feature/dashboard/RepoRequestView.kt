package com.documentary.repo_feature.dashboard

data class RepoRequestView(
    val url: String,
    val query: String,
    val pageNumber: Int,
    val pageSize: Int
)