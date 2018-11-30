package com.example.vlad.testproject.presentation.common

import android.view.View
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

abstract class BasePresenter<View:MvpView,MainRouter>:MvpPresenter<View>() {
}