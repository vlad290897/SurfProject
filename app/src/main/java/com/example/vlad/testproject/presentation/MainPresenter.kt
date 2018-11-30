package com.example.vlad.testproject.presentation

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vlad.testproject.network.NetworkApi
import javax.inject.Inject

@InjectViewState
class MainPresenter():MvpPresenter<MainView>() {

    fun getMovies(){
        Log.d("WORK","DAGGER")
    }
}