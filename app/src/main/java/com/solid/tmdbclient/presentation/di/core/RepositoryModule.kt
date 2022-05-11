package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.data.repository.ArtistsRepositoryImpl
import com.solid.tmdbclient.data.repository.MovieRepositoryImpl
import com.solid.tmdbclient.data.repository.TvShowRepositoryImpl
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsCacheDataSource
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsLocalDataSource
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.solid.tmdbclient.domain.repository.ArtistsRepository
import com.solid.tmdbclient.domain.repository.MovieRepository
import com.solid.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowRLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowRLocalDataSource, tvShowCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideArtistsRepository(
        artistsRemoteDataSource: ArtistsRemoteDataSource,
        artistsLocalDataSource: ArtistsLocalDataSource,
        artistsCacheDataSource: ArtistsCacheDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(artistsRemoteDataSource, artistsLocalDataSource, artistsCacheDataSource)
    }
}