package com.example.vlad.testproject.di.application

import com.example.vlad.testproject.data.MoviesRepositoryImp
import com.example.vlad.testproject.network.NetworkApi
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideMoviesRepository(networkApi: NetworkApi):MoviesRepositoryImp=MoviesRepositoryImp(networkApi)
}