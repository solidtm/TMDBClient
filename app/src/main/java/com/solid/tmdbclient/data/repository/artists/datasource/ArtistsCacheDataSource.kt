package com.solid.tmdbclient.data.repository.artists.datasource

import com.solid.tmdbclient.data.model.artists.Artist

interface ArtistsCacheDataSource {

    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}