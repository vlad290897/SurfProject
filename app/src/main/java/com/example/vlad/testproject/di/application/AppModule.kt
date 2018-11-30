package com.example.vlad.testproject.di.application

import android.app.Application
import android.content.Context
import com.example.vlad.testproject.data.MoviesRepositoryImp
import com.example.vlad.testproject.network.NetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Module
class AppModule(val app: Application) {
    @Provides
    fun provideAppContext(): Context = app
}