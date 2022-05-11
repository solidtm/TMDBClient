package com.solid.tmdbclient.presentation.di.tvshow

import com.solid.tmdbclient.presentation.artists.ArtistsActivity
import com.solid.tmdbclient.presentation.movie.MovieActivity
import com.solid.tmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent


//TvShow subcomponent to inject dependencies to TvShowActivity.
//hence we need to define and inject function here keeping an instance of TvShowActivity as a param

//we must define a subcomponent factory inside this TvShowSubComponent
//so that AppComponent knows how to create instances of this TvShowSubComponent
//we do this by creating an interface inside this interface.

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

     fun inject(tvShowActivity: TvShowActivity)

     @Subcomponent.Factory
     interface Factory{
         fun create() : TvShowSubComponent
     }

}