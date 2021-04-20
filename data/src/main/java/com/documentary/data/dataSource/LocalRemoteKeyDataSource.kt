package com.documentary.data.dataSource

import com.documentary.data.dao.repo.RemoteKeysDao
import com.documentary.data.dataSource.iDataSource.Readable
import com.documentary.data.dataSource.iDataSource.Writable
import com.documentary.data.entities.RemoteKeysModel
import javax.inject.Inject

class LocalRemoteKeyDataSource @Inject constructor
    (private val remoteKyDao: RemoteKeysDao) :
    LocalRemoteKeyDataSourceWritable,
    LocalRemoteKeyDataSourceReadable,
    LocalDataSourceDeletable {

    override fun write(input: List<RemoteKeysModel>) {
        remoteKyDao.insertAll(input)
    }

    override fun read(input: LocalRemoteKeyDataSourceReadable.Params): RemoteKeysModel {
        return remoteKyDao.remoteKeysRepoId(input.repoId)
    }

    override fun delete(input: Unit) {
        remoteKyDao.clearRemoteKeys()
    }

}
//typealias LocalRemoteKeyDataSourceDeletable = Deletable<Unit>

typealias LocalRemoteKeyDataSourceWritable = Writable<@JvmSuppressWildcards List<RemoteKeysModel>>

interface LocalRemoteKeyDataSourceReadable :
    Readable.Suspendable.IOLocal<LocalRemoteKeyDataSourceReadable.Params, RemoteKeysModel> {
    data class Params(val repoId: Long)
}