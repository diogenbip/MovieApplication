 package com.example.testappmovies.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappmovies.R
import com.example.testappmovies.adapters.GanreAdaptor
import com.example.testappmovies.models.Movie
import com.example.testappmovies.viewModel.mainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity() {
     lateinit var adaptor: GanreAdaptor
     lateinit var viewModel: mainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getData()

    }
    private fun initRecyclerView(){

        rv_movies.apply {
             setHasFixedSize(true)
            adaptor = GanreAdaptor()
             layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
             adapter =adaptor
         }
    }
    private fun getData(){
        viewModel = ViewModelProvider(this).get(mainActivityViewModel::class.java)
        viewModel.getRLO().observe(this,object :Observer<Movie>{
            override fun onChanged(t: Movie?) {
                if(t!=null){
                    adaptor.setList(t.content1)
                    adaptor.notifyDataSetChanged()
                }
                else{
                    Log.e("ErrorTAG","false data fetch")
                }
            }
        })
        viewModel.MakeAPICall()
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






