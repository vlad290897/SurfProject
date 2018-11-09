package com.example.vlad.testproject.ui

import com.example.vlad.testproject.models.ResponseMovie

interface MainViewInterface {
    fun displayMovies(responseMovie: ResponseMovie)
    fun displayError(s:String)
    fun hideProgress()
    fun hideSwipeRefreshProgress()
}