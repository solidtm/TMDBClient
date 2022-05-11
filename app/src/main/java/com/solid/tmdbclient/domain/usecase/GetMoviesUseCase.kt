package com.solid.tmdbclient.domain.usecase

import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase  @Inject constructor(private val movieRepository: MovieRepository) {

    //execute function of the getMovies use case from the repository
    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}