package com.documentary.domain.repo

import com.documentary.data.entities.repo.RepoEntity

fun RepoEntity.toRepo() = Repo(
    id = id,
    name = name,
    fullName = fullName,
    description = description,
    url = url,
    stars = stars,
    forks = forks,
    language = language
)