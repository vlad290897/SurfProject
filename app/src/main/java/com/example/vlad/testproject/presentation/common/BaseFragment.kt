package com.example.vlad.testproject.presentation.common

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment(), FragmentNavigation.View {
    var rootView: View? = null
    var fragmentNavigationPresenter: FragmentNavigation.Presenter? = null
    override fun attachPresenter(presenter: FragmentNavigation.Presenter) {
        fragmentNavigationPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(getLayout(), container, false)
        return rootView
    }

    override fun showSearchMovie() {
        displaySearchMovie()
    }
    abstract fun getLayout(): Int
    abstract fun displaySearchMovie()
}