package com.example.testappmovies

import android.app.Application
import com.example.testappmovies.services.DaggerRetroComponent
import com.example.testappmovies.services.RetroComponent
import com.example.testappmovies.services.RetroModule

class MyApp: Application() {
    private lateinit var rtComp:RetroComponent

    @Override
    override fun onCreate() {
        super.onCreate()
        rtComp = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComp():RetroComponent{
        return rtComp
    }

}