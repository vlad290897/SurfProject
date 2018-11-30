package com.example.vlad.testproject.di.movies

import com.example.vlad.testproject.di.screen.movies.MoviesScreenComponent
import com.example.vlad.testproject.di.screen.movies.MoviesScreenModule
import com.example.vlad.testproject.domain.MoviesInteractor
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MoviesModule::class))
@MovieScope
interface MoviesComponent {
    fun plusMovieScreenComponent(moviesScreenModule: MoviesScreenModule): MoviesScreenComponent
    fun moviesInteractor():MoviesInteractor
}