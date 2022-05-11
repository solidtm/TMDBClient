package com.solid.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.solid.tmdbclient.data.db.ArtistsDao
import com.solid.tmdbclient.data.db.MovieDao
import com.solid.tmdbclient.data.db.TMDBDatabase
import com.solid.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


//this class provides the Database and also the DAO interfaces for DI
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }


    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TVShowDao{
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistsDao(tmdbDatabase: TMDBDatabase): ArtistsDao{
        return tmdbDatabase.artistsDao()
    }
}