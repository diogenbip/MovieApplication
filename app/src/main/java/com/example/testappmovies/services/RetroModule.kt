package com.example.testappmovies.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public class RetroModule {

    private val BASE_URL="https://www.signalmediacorp.com/api/"

    private val client = OkHttpClient.Builder().build()
    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit:Retrofit):MovieAPI{
        return retrofit.create(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun GetInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}

