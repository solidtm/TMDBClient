package com.solid.tmdbclient.data.repository.movie.datasource

import com.solid.tmdbclient.data.model.movie.MovieList
import retrofit2.Response


interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}