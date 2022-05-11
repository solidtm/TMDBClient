package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.data.db.ArtistsDao
import com.solid.tmdbclient.data.db.MovieDao
import com.solid.tmdbclient.data.db.TVShowDao
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsLocalDataSource
import com.solid.tmdbclient.data.repository.artists.datasourceImpl.ArtistsLocalDataSourceImpl
import com.solid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.solid.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TVShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistsLocalDataSource(artistsDao: ArtistsDao): ArtistsLocalDataSource {
        return ArtistsLocalDataSourceImpl(artistsDao)
    }
}