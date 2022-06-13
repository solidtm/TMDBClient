package com.solid.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.repository.movie.FakeMovieRepository
import com.solid.tmdbclient.domain.usecase.GetMoviesUseCase
import com.solid.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.solid.tmdbclient.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//In this test class, we are going to run simulated android code,
// in our test source set, hence the need for Robolectric dependency
//we had to make this fake class for the dependencies found in the View model class on the use case.

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule    //add rule for
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //instances
    private lateinit var viewModel: MovieViewModel   //subject under test in this text class


    //here we will use a Fake for testing instead of a Mock
    //we will create a fake MovieRepository class
    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    //test functions

    @Test
    fun getMovies_returnCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }


    @Test
    fun updateMovies_returnsUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "posterPath3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))

        val updatedList = viewModel.updateMovieList().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}