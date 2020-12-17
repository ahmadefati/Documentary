package com.documentary.app.ui.event

import com.documentary.base.EventManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
abstract class AppEventModule {
    @Binds
    abstract fun bindAppNavigator(eventManager: AppEventManager): EventManager
}