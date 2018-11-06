package com.example.vlad.testproject.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.vlad.testproject.R
import com.example.vlad.testproject.adapters.MoviesAdapter
import com.example.vlad.testproject.models.Movie
import com.example.vlad.testproject.models.ResponseMovie
import com.example.vlad.testproject.network.NetworkApi
import com.example.vlad.testproject.network.NetworkClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainViewInterface {

    val presenter = MainPresenter(this)

    override fun displayMovies(responseMovie: ResponseMovie) {
        rv_movies.layoutManager = LinearLayoutManager(this)
        val adapter = MoviesAdapter(responseMovie.listMovie)
        rv_movies.adapter = adapter
    }

    override fun displayError(s: String) {
        Log.d("Error",s)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMoviesList()
    }

    private fun getMoviesList() {
        presenter.getMovies()
    }


}
