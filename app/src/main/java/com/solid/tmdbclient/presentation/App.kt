package com.solid.tmdbclient.presentation

import android.app.Application
import com.solid.tmdbclient.BuildConfig
import com.solid.tmdbclient.presentation.di.Injector
import com.solid.tmdbclient.presentation.di.artists.ArtistsSubComponent
import com.solid.tmdbclient.presentation.di.core.*
import com.solid.tmdbclient.presentation.di.movie.MovieSubComponent
import com.solid.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistsSubComponent(): ArtistsSubComponent {
        return appComponent.artistsSubComponent().create()
    }
}