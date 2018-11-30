package com.example.vlad.testproject.presentation

import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vlad.testproject.R
import com.example.vlad.testproject.presentation.common.BaseFragment
import com.example.vlad.testproject.presentation.fragments.movies.view.FragmentMovies

class MainActivity : AppCompatActivity(), MainView {
    override fun hideProgress() {

    }

    override fun showErrorFragment() {
    }


    var fragmentTransaction: FragmentTransaction? = null
    val TAG = "MainActivity"

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragmentMovies()

        //getMoviesList()
        //swipe_refresh.setOnRefreshListener(this)
        //  swipe_refresh.setColorSchemeResources(R.color.electric_blue)
        //  searchChangedListener(ET_search)
        // fragmentReplace()
    }


    //
//    override fun displayMovies(responseMovie: ResponseMovie) {
//        val listMoviesFragment = FragmentMovies()
//        fragmentTransaction?.add(R.id.frgm_container,listMoviesFragment)
//        fragmentTransaction?.commit()
//    }
//
//    override fun displayError(s: String) {
//        val myAwesomeSnackbar = Snackbar.make(
//                main_layout,
//                s,
//                Snackbar.LENGTH_LONG
//        )
//        myAwesomeSnackbar.show()
//        Log.d(TAG, "ERROR: $s")
//    }
//
//    override fun hideProgress() {
//        progress_bar.visibility = ProgressBar.INVISIBLE
//    }
//
//    private fun getMoviesList() {
//        presenter.getMovies()
//    }
//
//    override fun onRefresh() {
//        adapter?.clearItems()
    //   presenter.getMovies()
//}

    private fun searchChangedListener(searchEditText: EditText) {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d(TAG, "BeforeTextChanged")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    //    override fun displaySearchMovies(responseMovie: ResponseMovie) {
//        adapter?.clearItems()
//        displayMovies(responseMovie)
//    }
//
//    override fun hideSwipeRefreshProgress() {
//        swipe_refresh.isRefreshing = false
//    }
    fun showErrorFragment(baseFragment: BaseFragment) {
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction?.replace(R.id.frgm_container, baseFragment)
        fragmentTransaction?.commit()
    }

    private fun showFragmentMovies() {
        val listMoviesFragment = FragmentMovies()
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction?.add(R.id.frgm_container, listMoviesFragment)
        fragmentTransaction?.commit()

    }

}
