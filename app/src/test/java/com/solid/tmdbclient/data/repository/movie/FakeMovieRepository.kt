package com.solid.tmdbclient.data.repository.movie

import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.domain.repository.MovieRepository
//Fake movie repository class for testing
//implements the MovieRepository interface.

class FakeMovieRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))
    }


    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3, "overview3", "posterPath3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))

        return movies
    }
}