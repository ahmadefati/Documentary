package com.documentary.domain.repo

import androidx.room.Entity

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    val repoId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)