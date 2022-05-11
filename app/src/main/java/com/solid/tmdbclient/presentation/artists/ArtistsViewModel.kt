package com.solid.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.solid.tmdbclient.domain.usecase.GetArtistsUseCase
import com.solid.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtistsList() = liveData {
        val newArtistsList = updateArtistsUseCase.execute()
        emit(newArtistsList)
    }
}