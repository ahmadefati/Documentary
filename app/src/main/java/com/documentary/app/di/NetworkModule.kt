package com.documentary.app.di


import androidx.lifecycle.MutableLiveData
import com.documentary.app.BuildConfig
import com.documentary.app.ui.event.Event
import com.documentary.base.EventManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.ConnectionPool
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    companion object {
        const val HTTP_LOGGING_INTERCEPTOR = "http_logging_interceptor"
        const val RESPONSE_INTERCEPTOR = "response_interceptor"
    }

    @Provides
    fun provideOkHttpClient(

        @Named(HTTP_LOGGING_INTERCEPTOR)
        httpLoggingInterceptor: HttpLoggingInterceptor,

        @Named(RESPONSE_INTERCEPTOR)
        responseInterceptor: Interceptor

    ): OkHttpClient {
        val timeOut = 30L
        return OkHttpClient.Builder()
            .dispatcher(Dispatcher(Executors.newFixedThreadPool(20)).apply {
                maxRequests = 20
                maxRequestsPerHost = 20
            })
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(responseInterceptor)
            .connectionPool(ConnectionPool(100, timeOut, TimeUnit.SECONDS))
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .build()
    }

    @Named(HTTP_LOGGING_INTERCEPTOR)
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Named(RESPONSE_INTERCEPTOR)
    @Provides
    fun provideResponseInterceptor(eventManager: EventManager): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)

            when (response.code) {
                401 -> { // UnAuthorized
                    eventManager.unAuthorizedDetected()
                }
            }

            response
        }
    }

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideLiveData401(): MutableLiveData<Event<String>> = MutableLiveData()

}