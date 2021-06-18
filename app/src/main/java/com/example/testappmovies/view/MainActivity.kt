 package com.example.testappmovies.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compositeDisposable = CompositeDisposable()
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
         adapter =
             GanreAdaptor(response.content1)
     }

 }
 }

 /*
     private fun initRecyclerView() {
         rv_movies.apply{
             val layoutManager = LinearLayoutManager(this@MainActivity)
             val dividerItemDecoration = DividerItemDecoration(applicationContext,VERTICAL)
             addItemDecoration(dividerItemDecoration)
             adaptor = MovieAdaptor()
             adapter = adaptor
         }

     }

     fun loadAPIData(){
         val thread = Thread {
             try {
                 viewModel.makeApiCall()
                 viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
                 viewModel.getRecyclerListObserver().observe(this, Observer<Movie>{
                     if(it!=null) {
                         adaptor.movies = it.content1
                     }
                     else {
                         Log.e("TagError","false fetching data")
                     }
                 })

             }
             catch (e: Exception) {
                 e.printStackTrace()
             }
         }
         thread.start()

     }


     fun initRecycleView(){
         val recyclerView = findViewById<RecyclerView>(R.id.rv_movies)
         val layoutManager: LinearLayoutManager = GridLayoutManager(this, 2)
         recyclerView.setLayoutManager(layoutManager)
         val adaptor = MovieAdaptor()
         recyclerView.setAdapter(adaptor)


         viewModel =ViewModelProvider(this).get(MainActivityViewModel::class.java)
         viewModel.getMoviesListObserver()!!.observe(
             this,
             Observer<ArrayList<Content1_Items>> { movie_models ->
                 if (movie_models != null) {
                     adaptor.setMovieList(movie_models)
                 }
             },
         )

         viewModel.makeApiCall()
         /*viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

         val linerLayoutManager = LinearLayoutManager(applicationContext)
         linerLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
         rv_movies.layoutManager = linerLayoutManager
         adaptor = MovieAdaptor()
         adaptor.movieListData=viewModel.makeApiCall()
         rv_movies.adapter = adaptor*/
     }*/






