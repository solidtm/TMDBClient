package com.solid.tmdbclient.data.repository.movie.datasourceImpl

import com.solid.tmdbclient.data.api.TMDBService
import com.solid.tmdbclient.data.model.movie.MovieList
import com.solid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList>  = tmdbService.getPopularMovies(apiKey)
}