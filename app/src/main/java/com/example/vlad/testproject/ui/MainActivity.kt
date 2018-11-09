package com.example.vlad.testproject.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.ProgressBar
import com.example.vlad.testproject.R
import com.example.vlad.testproject.adapters.MoviesAdapter
import com.example.vlad.testproject.models.ResponseMovie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainViewInterface, SwipeRefreshLayout.OnRefreshListener {
    override fun hideSwipeRefreshProgress() {
        swipe_refresh.isRefreshing = false
    }


    var adapter: MoviesAdapter? = null
    val TAG = "MainActivity"
    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMoviesList()
        swipe_refresh.setOnRefreshListener(this)
        swipe_refresh.setColorSchemeResources(R.color.electric_blue)
    }

    override fun displayMovies(responseMovie: ResponseMovie) {
        rv_movies.layoutManager = LinearLayoutManager(this)
        adapter = MoviesAdapter(responseMovie.listMovie)
        rv_movies.adapter = adapter
    }

    override fun displayError(s: String) {
        val myAwesomeSnackbar = Snackbar.make(
                main_layout,
                s,
                Snackbar.LENGTH_LONG
        )
        myAwesomeSnackbar.show()
        Log.d(TAG, "ERROR: $s")
    }

    override fun hideProgress() {
        progress_bar.visibility = ProgressBar.INVISIBLE
    }

    private fun getMoviesList() {
        presenter.getMovies()
    }

    override fun onRefresh() {
        adapter?.clearItems()
        presenter.getMovies()
    }

}
