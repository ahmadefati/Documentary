package com.documentary.data.dataSource

import androidx.paging.PagingSource
import com.documentary.data.dao.repo.RepoDao
import com.documentary.data.dataSource.iDataSource.Deletable
import com.documentary.data.dataSource.iDataSource.Readable
import com.documentary.data.dataSource.iDataSource.Writable
import com.documentary.data.entities.RepoEntity
import javax.inject.Inject

class LocalRepoDataSource @Inject constructor
    (private val repoDao: RepoDao) :
    LocalRepoDataSourceReadable,
    LocalRepoDataSourceWritable,
    LocalDataSourceDeletable {
    override fun read(input: LocalRepoDataSourceReadable.Params): PagingSource<Int, RepoEntity> {
        return repoDao.reposByName(input.queryString)
    }

    override fun write(input: List<RepoEntity>) {
        repoDao.insertAll(input)
    }

    override fun delete(input: Unit) {
        repoDao.clearRepos()
    }

}
typealias LocalDataSourceDeletable = Deletable<Unit>
typealias LocalRepoDataSourceWritable = Writable<@JvmSuppressWildcards List<RepoEntity>>

interface LocalRepoDataSourceReadable :
    Readable.Suspendable.IOLocal<LocalRepoDataSourceReadable.Params, @JvmSuppressWildcards PagingSource<Int, RepoEntity>> {
    data class Params(val queryString: String)
}