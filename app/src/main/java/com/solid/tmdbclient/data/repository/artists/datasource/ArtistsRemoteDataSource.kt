package com.solid.tmdbclient.data.repository.artists.datasource

import com.solid.tmdbclient.data.model.artists.ArtistList
import retrofit2.Response


interface ArtistsRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}