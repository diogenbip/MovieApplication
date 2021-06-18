 package com.example.testappmovies.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappmovies.R
import com.example.testappmovies.adapters.GanreAdaptor
import com.example.testappmovies.models.Movie
import com.example.testappmovies.services.MovieApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_item.*
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.movie_poster.*


 class MainActivity : AppCompatActivity() {
     private val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        compositeDisposable.add(
            MovieApiService.buildService().getMovieList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))
    }


 private fun onFailure(t: Throwable) {
     Log.e("Error",t.toString())
 }

 private fun onResponse(response: Movie) {

     rv_movies.apply {
         setHasFixedSize(true)
         layoutManager = LinearLayoutManager(this@MainActivity)
         //список жанров
         adapter =
             GanreAdaptor(response.content1)
     }

 }


 }







