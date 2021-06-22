package com.example.testappmovies.services

import com.example.testappmovies.viewModel.mainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {
    fun inject(main: mainActivityViewModel){
    }

}