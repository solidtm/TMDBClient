package com.solid.tmdbclient.presentation.di

import com.solid.tmdbclient.presentation.di.artists.ArtistsSubComponent
import com.solid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.solid.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistsSubComponent(): ArtistsSubComponent
}