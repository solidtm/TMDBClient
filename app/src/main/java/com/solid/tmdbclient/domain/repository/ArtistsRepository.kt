package com.solid.tmdbclient.domain.repository

import com.solid.tmdbclient.data.model.artists.Artist

interface ArtistsRepository {

    suspend fun getArtists() : List<Artist>?

    suspend fun updateArtists() : List<Artist>?
}