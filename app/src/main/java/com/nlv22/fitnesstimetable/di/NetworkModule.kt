package com.nlv22.fitnesstimetable.di

import com.nlv22.fitnesstimetable.data.network.api.TrainingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://olimpia.fitnesskit-admin.ru"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun baseUrl() = BASE_URL

    @Provides
    fun loggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor())
        .build()

    @Provides
    @Singleton
    fun trainingServiceRetrofit(baseUrl: String): TrainingService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(TrainingService::class.java)
}
