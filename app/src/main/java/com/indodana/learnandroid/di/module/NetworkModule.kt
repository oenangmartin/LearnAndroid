package com.indodana.learnandroid.di.module

import com.indodana.learnandroid.BuildConfig
import com.indodana.learnandroid.data.api.ApiInterface
import com.indodana.learnandroid.helper.Constant
import com.indodana.learnandroid.repository.MovieRemoteDataSource
import com.indodana.learnandroid.repository.MovieRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideFilmApi(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(apiInterface: ApiInterface) =
        MovieRemoteDataSource(apiInterface)

    @Provides
    @Singleton
    fun provideRepository(movieRemoteDataSource: MovieRemoteDataSource) =
        MovieRepository(movieRemoteDataSource)

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()
}