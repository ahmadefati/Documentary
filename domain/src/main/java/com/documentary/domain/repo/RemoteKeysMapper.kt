package com.documentary.domain.repo

import com.documentary.data.entities.RemoteKeysModel

fun RemoteKeysModel.toRemoteKeys() = RemoteKeys(
    repoId = repoId,
    prevKey = prevKey,
    nextKey = nextKey
)