package com.solid.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.solid.tmdbclient.domain.usecase.GetTvShowUseCase
import com.solid.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }


    fun updateTvShowList() = liveData {
        val newTvShowList = updateTvShowsUseCase.execute()
        emit(newTvShowList)
    }
}