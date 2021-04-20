package com.documentary.repo_feature.dashboard


import com.documentary.domain.repo.RepoRequest

fun RepoRequest.toRepoRequestView() = RepoRequestView(
    url = url,
    query = query,
    pageNumber = pageNumber,
    pageSize = pageSize
)