package com.solid.tmdbclient.domain.usecase

import com.solid.tmdbclient.data.model.tv_show.TvShow
import com.solid.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Inject

class UpdateTvShowsUseCase @Inject constructor(private val tvShowRepository: TvShowRepository) {

    //execute function of the updateMovies use case from the repository
    suspend fun execute() : List<TvShow>? = tvShowRepository.updateTvShows()
}