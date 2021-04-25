package com.documentary.data.entities.repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeysModel(
    @PrimaryKey val repoId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)