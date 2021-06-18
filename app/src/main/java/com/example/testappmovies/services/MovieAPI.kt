package com.example.testappmovies.services

import com.example.testappmovies.models.Movie
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Headers

interface MovieAPI {
    @GET("main_page")
    fun  getMovieList(): Observable<Movie>
}