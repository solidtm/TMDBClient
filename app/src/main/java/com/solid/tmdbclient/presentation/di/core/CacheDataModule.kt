package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsCacheDataSource
import com.solid.tmdbclient.data.repository.artists.datasourceImpl.ArtistsCacheDataSourceImpl
import com.solid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.solid.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDatasource() : MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDatasource() : TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistsCacheDatasource() : ArtistsCacheDataSource {
        return ArtistsCacheDataSourceImpl()
    }
}