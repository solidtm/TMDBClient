package com.solid.tmdbclient.data.repository.movie.datasourceImpl

import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

//Her ewe are using a very basic caching mechanism using an arraylist of Movie instances.
class MovieCacheDataSourceImpl : MovieCacheDataSource {

    //cache
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}