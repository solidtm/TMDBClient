package com.solid.tmdbclient.presentation.di.movie

import com.solid.tmdbclient.presentation.artists.ArtistsActivity
import com.solid.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent


//Movie subcomponent to inject dependencies to MovieActivity.
//hence we need to define and inject function here keeping an instance of MovieActivity as a param

//we must define a subcomponent factory inside this MovieSubComponent
//so that AppComponent knows how to create instances of this MovieSubComponent
//we do this by creating an interface inside this interface.

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

     fun inject(movieActivity: MovieActivity)

     @Subcomponent.Factory
     interface Factory{
         fun create() : MovieSubComponent
     }

}