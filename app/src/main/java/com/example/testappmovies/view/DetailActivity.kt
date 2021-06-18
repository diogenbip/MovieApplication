package com.example.testappmovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.testappmovies.R
import com.example.testappmovies.adapters.LanguageAdaptor
import com.example.testappmovies.models.LanguagesItems
import kotlinx.android.synthetic.main.detail_movie.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_movie)
        init()
    }

    fun init(){
        var intent_detail = getIntent()
        var id = intent_detail?.getStringExtra("poster")
        var movie_title = intent_detail?.getStringExtra("title")
        var languages_array = ArrayList<LanguagesItems>()
        var created_at = intent_detail?.getStringExtra("created_at")
        languages_array = intent_detail.getSerializableExtra("languages") as ArrayList<LanguagesItems>

        Glide
            .with(this)
            .load("https://www.signalmediacorp.com//b/c/${id}.jpg")
            .into(img_poster_detail)
        created_at= created_at?.split(" ")?.get(0)
        movie_title_detail.text=movie_title
        created_at_detail.text=created_at
        rv_languages?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter =   LanguageAdaptor(languages_array)

        }
    }
}