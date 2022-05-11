package com.solid.tmdbclient.domain.usecase

import com.solid.tmdbclient.data.model.tv_show.TvShow
import com.solid.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Inject

class GetTvShowUseCase @Inject constructor(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()
}