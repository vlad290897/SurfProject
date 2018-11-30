package com.example.vlad.testproject.data

import com.example.vlad.testproject.network.NetworkApi
import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(val api: NetworkApi) : MoviesRepository {
    override fun getAllMovies(): Observable<ResponseMovie> =
            api.getMovies(API_KEY, "ru")
                    .subscribeOn(Schedulers.io())


    val API_KEY = "6ccd72a2a8fc239b13f209408fc31c33"

}
