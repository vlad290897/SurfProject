package com.example.vlad.testproject.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.vlad.testproject.R
import com.example.vlad.testproject.network.NetworkApi
import com.example.vlad.testproject.network.NetworkClient
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val response = NetworkClient.instance.create(NetworkApi::class.java)
        response.getMovies("6ccd72a2a8fc239b13f209408fc31c33")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ v-> Log.d("RxJava",v.listMovie.toString()) }, {e-> Log.d("RxError",e.toString())})
    }

}
