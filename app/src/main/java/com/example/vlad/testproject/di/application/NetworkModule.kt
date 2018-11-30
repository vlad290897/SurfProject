package com.example.vlad.testproject.di.application

import com.example.vlad.testproject.network.NetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
@Module
class NetworkModule {
    @Provides
    fun provideNetworkApi(retrofit: Retrofit): NetworkApi = retrofit.create(NetworkApi::class.java)

    @Provides
    fun provideRetrofitClient(): Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}