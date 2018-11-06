package com.example.vlad.testproject.ui

import android.util.Log
import com.example.vlad.testproject.R
import com.example.vlad.testproject.models.ResponseMovie
import com.example.vlad.testproject.network.NetworkApi
import com.example.vlad.testproject.network.NetworkClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val view: MainViewInterface) : MainPresenterInterface {
    val API_KEY = "6ccd72a2a8fc239b13f209408fc31c33"
    val TAG = "MainPresenter"

    override fun getMovies() {
        getObservable().subscribe(getObserver())
    }

  private  fun getObservable(): Observable<ResponseMovie> {
        return NetworkClient.instance.create(NetworkApi::class.java)
                .getMovies(API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

   private fun getObserver(): Observer<ResponseMovie> {
        return object : Observer<ResponseMovie> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG,"Subscribed")
            }

            override fun onComplete() {
                Log.d(TAG,"Completed")
            }

            override fun onNext(t: ResponseMovie) {
                view.displayMovies(t)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"Error $e")
                e.printStackTrace()
                view.displayError("Проверьте ваше соединение с интернетом и попробуйте еще раз")
            }

        }
    }

}