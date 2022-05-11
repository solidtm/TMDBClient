package com.solid.tmdbclient.data.repository

import android.util.Log
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.solid.tmdbclient.domain.repository.MovieRepository


//This class implements the movie repository interface created in the domain layer
//and depends on data sources already created
//we then create functions for getting movies from api, database, and cache using those data sources.

//for the getMovies() function, we make call to get movie from the cache, if none is available,
//the cache function makes call to get from DB, and if none is available,
//the db  function makes call to get from the API source.

//to update movies, we need to get updated movie data from the web API first
// clear the movie data in the database
// save the new movies list to the database and cache and then return that new movies list.



class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository{

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    //functions to get movies from API
    private suspend fun getMoviesFromAPI() : List<Movie> {
        lateinit var movieList: List<Movie>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()

            if (body != null){
                movieList = body.movies    //response from API comes as a Movie list object
            }

        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        return movieList
    }


    //function to get movies from DB
    private suspend fun getMoviesFromDB() : List<Movie>{
        lateinit var movieList: List<Movie>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
           movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        //check movieList
        if (movieList.isNotEmpty()){  //means there are movie data available, just return it
            return movieList
        }else{  //we fetch movies from remote source and save to DB
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }


    //function to getMovies from cache
    private suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        //check movieList
        if (movieList.isNotEmpty()){  //means there are movie data available, just return it
            return movieList
        }else{  //we fetch movies from database and save to cache
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}












