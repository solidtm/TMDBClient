package com.solid.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solid.tmdbclient.data.model.movie.Movie

//we have 3 operations here:
//1. Save a list of movie instances taken from the TMDB API to the database
//2. When user clicks on the update icon, we need to delete all the items in the list and then save new instances to the database.
//3. Get a list of movie instances to display using a recyclerview
// Since we are using coroutines, we should use suspend functions

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun saveMovies(movies: List<Movie>)

   @Query("DELETE FROM popular_movies")
   suspend fun deleteAllMovies()

   @Query("SELECT * FROM popular_movies")
   suspend fun getMovies() : List<Movie>
}