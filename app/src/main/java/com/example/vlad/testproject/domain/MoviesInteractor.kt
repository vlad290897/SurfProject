package com.example.vlad.testproject.domain

import com.example.vlad.testproject.data.MoviesRepository
import com.example.vlad.testproject.data.MoviesRepositoryImp
import com.example.vlad.testproject.presentation.fragments.movies.model.ResponseMovie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject

class MoviesInteractor(val repositoryMovies: MoviesRepositoryImp):Interactor {
    override fun getMovies(): BehaviorSubject<ResponseMovie> {
        val subject:BehaviorSubject<ResponseMovie> = BehaviorSubject.create()
        repositoryMovies.getAllMovies()
                .subscribe(subject)
        return subject
    }


}