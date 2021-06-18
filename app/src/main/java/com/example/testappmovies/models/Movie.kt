package com.example.testappmovies.models

import com.google.gson.annotations.SerializedName


data class Movie (

    @SerializedName("content") var content1 : ArrayList<Content1_Items>

)