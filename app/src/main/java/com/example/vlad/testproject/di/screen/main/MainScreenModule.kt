package com.example.vlad.testproject.di.screen.main

import com.example.vlad.testproject.presentation.MainPresenter
import dagger.Module
import dagger.Provides


@Module
class MainScreenModule {
    @Provides
    fun provideMainPresenter() = MainPresenter()
}