package com.documentary.app.di

import android.content.SharedPreferences
import com.documentary.base.Constants
import com.documentary.base.di.KeyFirstOpen
import com.documentary.base.di.KeyName
import com.documentary.base.di.KeyWeight
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Suppress("unused")
@Module
@InstallIn(ActivityComponent::class)
class PreferencesModule {

    @Provides
    @ActivityScoped
    @KeyFirstOpen
    fun provideIsFirstOpen(sharedPrefs: SharedPreferences): Boolean =
        sharedPrefs.getBoolean(Constants.KEY_FIRST_TIME_TOGGLE, true)

    @Provides
    @ActivityScoped
    @KeyName
    fun provideName(sharedPrefs: SharedPreferences): String =
        sharedPrefs.getString(Constants.KEY_NAME, "") ?: ""

    @Provides
    @ActivityScoped
    @KeyWeight
    fun provideWeight(sharedPrefs: SharedPreferences): Float =
        sharedPrefs.getFloat(Constants.KEY_WEIGHT, 80f)

}