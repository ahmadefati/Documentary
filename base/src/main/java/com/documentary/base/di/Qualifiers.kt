package com.documentary.base.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KeyName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KeyWeight

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KeyFirstOpen