package com.solid.tmdbclient.presentation.di.tvshow

import com.solid.tmdbclient.domain.usecase.GetArtistsUseCase
import com.solid.tmdbclient.domain.usecase.GetTvShowUseCase
import com.solid.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.solid.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.solid.tmdbclient.presentation.artists.ArtistsViewModelFactory
import com.solid.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

//TvShow module to produce the TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUseCase: GetTvShowUseCase, updateTvShowsUseCase: UpdateTvShowsUseCase): TvShowViewModelFactory{
            return TvShowViewModelFactory(getTvShowUseCase, updateTvShowsUseCase)
    }
}