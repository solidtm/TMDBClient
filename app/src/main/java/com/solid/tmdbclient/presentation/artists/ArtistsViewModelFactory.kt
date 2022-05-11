package com.solid.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solid.tmdbclient.domain.usecase.GetArtistsUseCase
import com.solid.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistsViewModelFactory (
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
    ) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}