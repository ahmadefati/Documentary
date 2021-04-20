package com.documentary.home_feature

import com.documentary.domain.repo.Repo
import com.documentary.repo_feature.dashboard.RepoView

fun Repo.toRepoView() = RepoView(
    id = id,
    name = name,
    fullName = fullName,
    description = description,
    url = url,
    stars = stars,
    forks = forks,
    language = language
)