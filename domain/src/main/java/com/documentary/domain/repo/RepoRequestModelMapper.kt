package com.documentary.domain.repo

import com.documentary.data.entities.repo.RepoRequestModel

fun RepoRequestModel.toRepoRequest() = RepoRequest(
    url = url,
    query = query,
    pageNumber = pageNumber,
    pageSize = pageSize
)