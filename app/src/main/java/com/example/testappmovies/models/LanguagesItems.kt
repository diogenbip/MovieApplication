package com.example.testappmovies.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class LanguagesItems(
    @SerializedName("title") var language_title:String?
):Serializable