package com.documentary.repo_feature.dashboard

import com.documentary.domain.repo.RemoteKeys

fun RemoteKeys.toRemoteKeysView() = RemoteKeysView(
    repoId = repoId,
    prevKey = prevKey,
    nextKey = nextKey
)