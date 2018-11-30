package com.example.vlad.testproject.presentation.fragments.movies.view

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.vlad.testproject.R
import com.example.vlad.testproject.di.MoviesApplication
import com.example.vlad.testproject.presentation.adapters.MoviesAdapter
import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie
import com.example.vlad.testproject.presentation.fragments.movies.presenter.MoviesPresenter
import kotlinx.android.synthetic.main.list_movies_fragment.*
import javax.inject.Inject

class FragmentMovies : MvpFragment(), MoviesView, SwipeRefreshLayout.OnRefreshListener {
    override fun hideProgress() {

    }


    override fun onRefresh() {

    }

    @Inject
    lateinit var daggerPresenter: MoviesPresenter
    @InjectPresenter
    lateinit var moxyPresenter: MoviesPresenter
    @ProvidePresenter
    fun providePresenter():MoviesPresenter = daggerPresenter


    var adapter: MoviesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        moxyPresenter.test()
        return inflater?.inflate(R.layout.list_movies_fragment, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val application: MoviesApplication = (activity.application as MoviesApplication)
        application.plusMoviesComponent()
        application.plusMoviesScreenComponent()?.inject(this)

    }

    override fun displayMovies(responseMovie: ResponseMovie) {
        val context = activity
        rv_movies.layoutManager = LinearLayoutManager(context)
        adapter = MoviesAdapter(responseMovie.listMovie)
        rv_movies.adapter = adapter
    }


}