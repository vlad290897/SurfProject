package com.example.vlad.testproject.presentation.common

interface FragmentNavigation {
    interface View{
        fun attachPresenter(presenter: Presenter)
        fun showSearchMovie()
    }

    interface Presenter{
        fun addFragment(baseFragment: BaseFragment)
        fun hideProgress()
    }
}