package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Dependency injection for the remote source module
//provides Retrofit instance using the base url.

@Module
class NetModule (private val baseUrl: String){

    //Provider function to provide retrofit instance (singleton)
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    //Provider function to provide TMDB service instance (singleton)
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}