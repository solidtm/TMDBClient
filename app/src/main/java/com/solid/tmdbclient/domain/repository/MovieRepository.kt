package com.solid.tmdbclient.domain.repository

import com.solid.tmdbclient.data.model.movie.Movie

//here we define abstract functions that represent each use-case in the project
//since using kotlin coroutines, we will use suspend functions and we make return types null safe

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?
}