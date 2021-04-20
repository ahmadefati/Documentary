package com.documentary.repo_feature.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeysView(
    @PrimaryKey val repoId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)