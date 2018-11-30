package com.example.vlad.testproject.data

import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie
import io.reactivex.Observable

interface MoviesRepository {
    fun getAllMovies(): Observable<ResponseMovie>
}