package com.solid.tmdbclient.data.repository.artists.datasourceImpl

import com.solid.tmdbclient.data.api.TMDBService
import com.solid.tmdbclient.data.model.artists.ArtistList
import com.solid.tmdbclient.data.model.movie.MovieList
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ) : ArtistsRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList>  = tmdbService.getPopularArtists(apiKey)

}