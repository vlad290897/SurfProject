package com.example.vlad.testproject.presentation.fragments.movies.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie

@StateStrategyType(AddToEndSingleStrategy::class)
interface MoviesView : MvpView {
    fun hideProgress()
    fun displayMovies(responseMovie: ResponseMovie)
}