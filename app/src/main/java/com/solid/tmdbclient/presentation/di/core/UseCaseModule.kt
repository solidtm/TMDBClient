package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.domain.repository.ArtistsRepository
import com.solid.tmdbclient.domain.repository.MovieRepository
import com.solid.tmdbclient.domain.repository.TvShowRepository
import com.solid.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }


    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistsUseCase(artistsRepository: ArtistsRepository) : GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }


    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistsRepository)
    }

}