package com.solid.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.solid.tmdbclient.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)  //annotation to run with AndroidJUnit4
class MovieDaoTest {

    //since we are using architecture components, and to execute those tasks asynchronously, we need to use InstantTaskExecutorRule
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //reference variable for the MovieDao and database class
    private lateinit var movieDao : MovieDao
    private lateinit var database : TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(    //construct instances
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        movieDao = database.movieDao()
    }


    //close database after testing using teardown function
    @After
    fun tearDown() {
        database.close()
    }


    //test function to test the saveMovies function.
    @Test
    fun saveMoviesTest()  = runBlocking{

        //create list of movie objects
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "date1", "title1"),
            Movie(2, "overview2", "posterPath2", "date2", "title2"),
            Movie(3, "overview3", "posterPath3", "date3", "title3")
        )

        movieDao.saveMovies(movies)     //save the data to the database

        val allMovies = movieDao.getMovies() //Get all those movies put in the data base.

        Truth.assertThat(allMovies).isEqualTo(movies) //compare it to movies sent to db
    }


    //test function to test the deleteMovies function.
    @Test
    fun deleteMovies() = runBlocking{

        //put some movies in db
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "date1", "title1"),
            Movie(2, "overview2", "posterPath2", "date2", "title2"),
            Movie(3, "overview3", "posterPath3", "date3", "title3")
        )

        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()

        val moviesResult = movieDao.getMovies()
        Truth.assertThat(moviesResult).isEmpty()
    }
}














