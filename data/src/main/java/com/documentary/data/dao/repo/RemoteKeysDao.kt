package com.documentary.data.dao.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.documentary.data.entities.repo.RemoteKeysModel

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKeyModel: List<RemoteKeysModel>)

    @Query("SELECT * FROM remote_keys WHERE repoId = :repoId")
    fun remoteKeysRepoId(repoId: Long): RemoteKeysModel

    @Query("DELETE FROM remote_keys")
    fun clearRemoteKeys()
}