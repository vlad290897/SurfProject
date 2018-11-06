package com.example.vlad.testproject.network

import com.example.vlad.testproject.models.ResponseMovie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("3/discover/movie?language=ru")
    fun getMovies(@Query("api_key") apiKey:String):Observable<ResponseMovie>
}