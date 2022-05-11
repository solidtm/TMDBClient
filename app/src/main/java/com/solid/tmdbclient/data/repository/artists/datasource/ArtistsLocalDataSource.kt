package com.solid.tmdbclient.data.repository.artists.datasource

import com.solid.tmdbclient.data.model.artists.Artist


interface ArtistsLocalDataSource {

    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}