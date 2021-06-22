package com.example.testappmovies.models

import com.google.gson.annotations.SerializedName

data class Content2_Items (

    @SerializedName("title") var movie_title : String,
    @SerializedName("cover") var cover : Cover,
    @SerializedName("languages") val languages:ArrayList<LanguagesItems>,
    @SerializedName("created_at") val created_at: String?
)

