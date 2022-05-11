package com.solid.tmdbclient.domain.usecase

import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.domain.repository.ArtistsRepository
import javax.inject.Inject

class GetArtistsUseCase @Inject constructor(private val artistsRepository: ArtistsRepository) {

    suspend fun execute() : List<Artist>? = artistsRepository.getArtists()
}