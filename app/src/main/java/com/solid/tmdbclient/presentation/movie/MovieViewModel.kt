package com.solid.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.solid.tmdbclient.domain.usecase.GetMoviesUseCase
import com.solid.tmdbclient.domain.usecase.UpdateMoviesUseCase

//this view model class has constructor parameters, therefore we will create a ViewModel factory for it.
class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    //make calls to the use case functions for each use case
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }


    fun updateMovieList() = liveData {
        //clear all data in the movie table of the database, download data from api adn save them to database
        //we have done the above in the data layer and we just need to make call to the execute function of the use case.
        val updatedMovieList = updateMoviesUseCase.execute()
        emit(updatedMovieList)
    }
}