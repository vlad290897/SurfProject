package com.example.vlad.testproject.di.screen.movies

import android.util.Log
import com.example.vlad.testproject.domain.MoviesInteractor
import com.example.vlad.testproject.presentation.fragments.movies.presenter.MoviesPresenter
import dagger.Module
import dagger.Provides

@Module
class MoviesScreenModule {

@Provides
fun provideMoviePresenter(moviesInteractor: MoviesInteractor):MoviesPresenter {
    Log.d("PROVIDEPRESENTER","PRESENTERPROVIDED")
   return MoviesPresenter(moviesInteractor)
}
}