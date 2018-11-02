package com.example.vlad.testproject.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    var ourInstance:Retrofit? = null
    val instance:Retrofit
    get() {
        if(ourInstance==null){
            ourInstance = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("https://api.themoviedb.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return ourInstance!!

    }
}