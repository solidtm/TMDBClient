package com.solid.tmdbclient.presentation.di.artists

import com.solid.tmdbclient.domain.usecase.GetArtistsUseCase
import com.solid.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.solid.tmdbclient.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

//artists module to produce the ArtistsViewModelFactory

@Module
class ArtistsModule {

    @ArtistsScope
    @Provides
    fun provideArtistsViewModelFactory(getArtistsUseCase: GetArtistsUseCase, updateArtistsUseCase: UpdateArtistsUseCase): ArtistsViewModelFactory{
            return ArtistsViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }


}