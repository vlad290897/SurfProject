package com.example.vlad.testproject.di.movies

import com.example.vlad.testproject.data.MoviesRepositoryImp
import com.example.vlad.testproject.domain.MoviesInteractor
import dagger.Module
import dagger.Provides

@Module
class MoviesModule {
    @Provides
    fun provideMoviesInteractor(moviesRepositoryImp: MoviesRepositoryImp):MoviesInteractor = MoviesInteractor(moviesRepositoryImp)
}