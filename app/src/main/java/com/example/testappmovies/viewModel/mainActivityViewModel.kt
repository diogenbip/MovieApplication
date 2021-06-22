package com.example.testappmovies.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.testappmovies.MyApp
import com.example.testappmovies.models.Movie
import com.example.testappmovies.services.MovieAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class mainActivityViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var mService:MovieAPI
    lateinit var liveDataList:MutableLiveData<Movie>

    init{
        (application as MyApp).getRetroComp().inject(this)
        liveDataList = MutableLiveData()
    }
    public fun getRLO():MutableLiveData<Movie>{
        return liveDataList
    }

    fun MakeAPICall(){
        mService.getMovieList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({response -> liveDataList.postValue(response)}, {liveDataList.postValue(null)})
    }


}