package com.documentary.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.room.Room
import com.androiddevs.res.R
import com.documentary.base.Constants
import com.documentary.data.db.DocumentaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        DocumentaryDatabase::class.java,
        Constants.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @ApplicationContext context: Context,
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.API_URL))
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
    }

    /* @Provides
     @OkHttpQualifier
     fun secondRetrofit(
         @ApplicationContext context: Context,
         client: OkHttpClient,
         converterFactory: GsonConverterFactory
     ): Retrofit {
         return Retrofit.Builder()
             .baseUrl(context.getString(R.string.API_URL_REPO))
             .client(client)
             .addConverterFactory(converterFactory)
             .build()
     }*/

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.createDataStore(name = Constants.SHARED_PREFS_NAME)


}