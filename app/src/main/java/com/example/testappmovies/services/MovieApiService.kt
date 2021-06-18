package com.example.testappmovies.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MovieApiService {

    private const val BASE_URL="https://www.signalmediacorp.com/api/"

    private val client = OkHttpClient.Builder().build()

    private val retrofit =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(MovieAPI::class.java)
    fun buildService():MovieAPI{
        return retrofit
    }
}

