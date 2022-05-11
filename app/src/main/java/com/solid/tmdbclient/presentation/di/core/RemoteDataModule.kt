package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.data.api.TMDBService
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.solid.tmdbclient.data.repository.artists.datasourceImpl.ArtistsRemoteDataSourceImpl
import com.solid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.solid.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//DI module to provide the data sources we have the repositories dependent on
//same with other dataModules(local and cache

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }


    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistsRemoteDataSource(tmdbService: TMDBService): ArtistsRemoteDataSource {
        return ArtistsRemoteDataSourceImpl(tmdbService, apiKey)
    }
}