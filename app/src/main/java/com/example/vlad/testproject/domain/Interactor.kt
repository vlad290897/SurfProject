package com.example.vlad.testproject.domain

import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

interface Interactor {
    fun getMovies():BehaviorSubject<ResponseMovie>
}