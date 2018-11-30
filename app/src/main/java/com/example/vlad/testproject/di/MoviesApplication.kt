package com.example.vlad.testproject.di

import android.app.Application
import android.util.Log
import com.example.vlad.testproject.di.application.AppComponent
import com.example.vlad.testproject.di.application.AppModule
import com.example.vlad.testproject.di.application.DaggerAppComponent
import com.example.vlad.testproject.di.movies.MoviesComponent
import com.example.vlad.testproject.di.movies.MoviesModule
import com.example.vlad.testproject.di.screen.movies.MoviesScreenComponent
import com.example.vlad.testproject.di.screen.movies.MoviesScreenModule

class MoviesApplication : Application() {
    lateinit var appComponent: AppComponent
    var moviesComponent: MoviesComponent? = null
    var moviesScreenComponent: MoviesScreenComponent? = null

    fun plusMoviesComponent(): MoviesComponent? {
        if (moviesComponent == null) {
            moviesComponent = appComponent.plusMovieComponent(MoviesModule())
        }
        return moviesComponent
    }

    fun clearMoviesComponent() {
        moviesComponent = null
    }


    fun plusMoviesScreenComponent(): MoviesScreenComponent? {
        if (moviesScreenComponent == null) {
            Log.d("PlusMovies","SCREEN!")
            moviesScreenComponent = moviesComponent?.plusMovieScreenComponent(MoviesScreenModule())
        }
        return moviesScreenComponent
    }

    fun clearMoviesScreenComponent() {
        moviesScreenComponent = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}