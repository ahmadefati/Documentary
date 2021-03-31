package com.documentary.app.di

import com.documentary.data.dataSource.*
import com.documentary.data.remote.RemoteRepoDataSource
import com.documentary.data.remote.RemoteRepoDataSourceReadable
import com.documentary.data.repos.GithubRepository
import com.documentary.data.repos.IGithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class DataSourceModule {


    @Binds
    @ActivityRetainedScoped
    abstract fun provideRemoteRepoDataSourceReadable(dataSource: RemoteRepoDataSource): RemoteRepoDataSourceReadable


    @Binds
    @ActivityRetainedScoped
    abstract fun provideLocalRemoteKeyDataSourceWritable(dataSource: LocalRemoteKeyDataSource): LocalRemoteKeyDataSourceWritable

    @Binds
    @ActivityRetainedScoped
    abstract fun provideLocalRemoteKeyDataSourceReadable(dataSource: LocalRemoteKeyDataSource): LocalRemoteKeyDataSourceReadable

    @Binds
    @ActivityRetainedScoped
    abstract fun provideLocalRepoDataSourceReadable(dataSource: LocalRepoDataSource): LocalRepoDataSourceReadable

    @Binds
    @ActivityRetainedScoped
    abstract fun provideLocalRepoDataSourceWritable(dataSource: LocalRepoDataSource): LocalRepoDataSourceWritable

    @Binds
    @ActivityRetainedScoped
    abstract fun provideLocalRepoDataSourceDeletable(dataSource: LocalRepoDataSource): LocalDataSourceDeletable


    @ActivityRetainedScoped
    @Binds
    abstract fun provideRepository(githubRepository: GithubRepository): IGithubRepository


}