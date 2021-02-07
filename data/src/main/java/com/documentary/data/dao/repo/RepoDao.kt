package com.documentary.data.dao.repo

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.documentary.data.entities.Repo

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<Repo>)

    @Query(
        "SELECT * FROM repos WHERE " +
                "name LIKE :queryString OR description LIKE :queryString " +
                "ORDER BY stars DESC, name ASC"
    )
    fun reposByName(queryString: String): PagingSource<Int, Repo>

    @Query("DELETE FROM repos")
    fun clearRepos()

}