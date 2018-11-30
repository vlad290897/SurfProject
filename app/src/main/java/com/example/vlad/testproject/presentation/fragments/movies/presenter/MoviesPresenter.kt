package com.example.vlad.testproject.presentation.fragments.movies.presenter

import android.util.Log
import com.arellomobile.mvp.MvpPresenter
import com.example.vlad.testproject.domain.MoviesInteractor
import com.example.vlad.testproject.presentation.fragments.movies.view.MoviesView
import javax.inject.Inject

class MoviesPresenter @Inject constructor(val moviesInteractor: MoviesInteractor):MvpPresenter<MoviesView>() {
    fun test(){
        Log.d("PRESENTERFRAGMENT","PRESENTER WORK")
    }
}