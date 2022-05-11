package com.solid.tmdbclient.data.repository.tvshow.datasource

import com.solid.tmdbclient.data.model.tv_show.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()

}