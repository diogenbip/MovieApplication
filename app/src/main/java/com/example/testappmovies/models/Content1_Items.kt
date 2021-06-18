package com.example.testappmovies.models

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class Content1_Items(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("title")
    val title_ganre:String?,
    @SerializedName("content")
    val content2:ArrayList<Content2_Items>,



)

