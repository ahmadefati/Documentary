package com.documentary.app.di

import com.documentary.data.services.RepoService
import com.documentary.data.services.SampleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideSampleService(retrofit: Retrofit): SampleService =
        retrofit.create(SampleService::class.java)

    @Provides
    @Singleton
    fun provideRepoService(retrofit: Retrofit): RepoService =
        retrofit.create(RepoService::class.java)

    /* @Provides
     @Singleton
     private fun provideGithubRepository(context: Context): GithubRepository {
         return GithubRepository(RepoService, DocumentaryDatabase.getInstance(context))
     }*/

}