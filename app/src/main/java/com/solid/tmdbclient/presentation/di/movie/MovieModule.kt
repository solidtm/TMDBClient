package com.solid.tmdbclient.presentation.di.movie

import com.solid.tmdbclient.domain.usecase.GetMoviesUseCase
import com.solid.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.solid.tmdbclient.presentation.artists.ArtistsViewModelFactory
import com.solid.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

//artists module to produce the MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase, updateMoviesUseCase: UpdateMoviesUseCase): MovieViewModelFactory {
            return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}