package com.solid.tmdbclient.domain.usecase

import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.domain.repository.ArtistsRepository
import javax.inject.Inject

class UpdateArtistsUseCase @Inject constructor(private val artistsRepository: ArtistsRepository) {

    //execute function of the updateMovies use case from the repository
    suspend fun execute() : List<Artist>? = artistsRepository.updateArtists()
}