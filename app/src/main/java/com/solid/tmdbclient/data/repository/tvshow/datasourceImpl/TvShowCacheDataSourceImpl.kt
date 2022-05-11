package com.solid.tmdbclient.data.repository.tvshow.datasourceImpl

import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.model.tv_show.TvShow
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource{

    //cache
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}