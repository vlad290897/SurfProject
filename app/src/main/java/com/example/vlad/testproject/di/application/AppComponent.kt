package com.example.vlad.testproject.di.application

import android.app.Application
import android.content.Context
import com.example.vlad.testproject.data.MoviesRepositoryImp
import com.example.vlad.testproject.di.movies.MoviesComponent
import com.example.vlad.testproject.di.movies.MoviesModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class,NetworkModule::class,DataModule::class))
@Singleton
interface AppComponent {
    fun plusMovieComponent(moviesModule: MoviesModule):MoviesComponent
    fun context():Context
    fun inject(app:Application)
    fun moviesRepository():MoviesRepositoryImp
}