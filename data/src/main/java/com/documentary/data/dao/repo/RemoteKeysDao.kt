package com.documentary.data.dao.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.documentary.data.entities.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM remote_keys WHERE repoId = :repoId")
    fun remoteKeysRepoId(repoId: Long): RemoteKeys

    @Query("DELETE FROM remote_keys")
    fun clearRemoteKeys()
}