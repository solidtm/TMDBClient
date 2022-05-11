package com.solid.tmdbclient.data.repository.tvshow.datasourceImpl

import com.solid.tmdbclient.data.api.TMDBService
import com.solid.tmdbclient.data.model.tv_show.TvShowList
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String)
    : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}