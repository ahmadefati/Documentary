package com.documentary.app.di

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

}