package com.solid.tmdbclient.presentation.di.core

import com.solid.tmdbclient.presentation.di.artists.ArtistsSubComponent
import com.solid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.solid.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
    RepositoryModule::class
])
interface AppComponent {

    //here we will define functions to get the subcomponent factories
    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistsSubComponent() : ArtistsSubComponent.Factory
}