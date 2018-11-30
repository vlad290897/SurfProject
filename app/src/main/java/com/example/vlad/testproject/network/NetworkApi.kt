package com.example.vlad.testproject.network

import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie
import dagger.Provides
import io.reactivex.Observable
import retrofit2.http.*

interface NetworkApi {
    @GET("3/discover/movie")
    fun getMovies(@Query("api_key") apiKey: String,@Query("language") lang:String): Observable<ResponseMovie>

    @GET("3/search/movie?language=ru")
    fun searchMovie(@Query("query") title:String, @Query("api_key") apiKey: String):Observable<ResponseMovie>
}