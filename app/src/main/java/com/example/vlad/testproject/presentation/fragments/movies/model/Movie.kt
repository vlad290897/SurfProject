package com.example.vlad.testproject.presentation.fragments.movies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("title")
                 @Expose
                 val title: String,
                 @SerializedName("overview")
                 @Expose
                 val description: String,
                 @SerializedName("release_date")
                 @Expose
                 val releaseDate: String,
                 @SerializedName("poster_path")
                 @Expose
                 val image:String
                 )