package com.solid.tmdbclient.presentation.di.core

import android.content.Context
import com.solid.tmdbclient.presentation.di.artists.ArtistsSubComponent
import com.solid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.solid.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistsSubComponent::class])  //list the subcomponents here for movies, tvShow and artists
class AppModule(private val context : Context){

   @Singleton
   @Provides

   fun provideApplicationContext(): Context{
       return context.applicationContext
   }
}