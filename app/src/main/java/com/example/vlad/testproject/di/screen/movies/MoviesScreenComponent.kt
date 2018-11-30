package com.example.vlad.testproject.di.screen.movies

import com.example.vlad.testproject.di.screen.ScreenScope
import com.example.vlad.testproject.presentation.fragments.movies.presenter.MoviesPresenter
import com.example.vlad.testproject.presentation.fragments.movies.view.FragmentMovies
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MoviesScreenModule::class))
@ScreenScope
interface MoviesScreenComponent {
    fun inject(fragmentMovies: FragmentMovies)
    fun getPresenter(): MoviesPresenter
}