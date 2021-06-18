package com.example.testappmovies.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class LanguagesItems(
    @SerializedName("title") var language_title:String?
):Serializable