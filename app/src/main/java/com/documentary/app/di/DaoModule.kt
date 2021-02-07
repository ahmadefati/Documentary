package com.documentary.app.di

import com.documentary.data.db.DocumentaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideCountryDAO(db: DocumentaryDatabase) = db.countryDao()

    @Provides
    @Singleton
    fun provideCountryInfoDAO(db: DocumentaryDatabase) = db.countryInfoDao()

    @Provides
    @Singleton
    fun provideAllInfoDAO(db: DocumentaryDatabase) = db.allInfoDao()

    @Provides
    @Singleton
    fun provideRepoDAO(db: DocumentaryDatabase) = db.reposDao()

    @Provides
    @Singleton
    fun provideRemoteKeysDAO(db: DocumentaryDatabase) = db.remoteKeysDao()


//    ********************************************

//    @Binds
//    @ActivityRetainedScoped
//    fun provideRemoteRepoDataSourceReadable(dataSource: RemoteRepoDataSource) : RemoteRepoDataSourceReadable


}