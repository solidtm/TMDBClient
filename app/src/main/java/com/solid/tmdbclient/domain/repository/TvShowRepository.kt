package com.solid.tmdbclient.domain.repository

import com.solid.tmdbclient.data.model.tv_show.TvShow

interface TvShowRepository {

    suspend fun getTvShows() : List<TvShow>?

    suspend fun updateTvShows() : List<TvShow>?
}