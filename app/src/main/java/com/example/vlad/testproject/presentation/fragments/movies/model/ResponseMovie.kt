package com.example.vlad.testproject.presentation.fragments.movies.model

import com.example.vlad.testproject.presentation.fragments.movies.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseMovie(@SerializedName("page")
                         @Expose
                         val page: String,
                         @SerializedName("results")
                         @Expose
                         val listMovie:ArrayList<Movie>
)