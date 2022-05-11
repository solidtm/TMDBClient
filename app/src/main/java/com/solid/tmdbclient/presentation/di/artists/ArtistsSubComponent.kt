package com.solid.tmdbclient.presentation.di.artists

import com.solid.tmdbclient.presentation.artists.ArtistsActivity
import dagger.Subcomponent


//Artists subcomponent to inject dependencies to artistsActivity.
//hence we need to define and inject function here keeping an instance of ArtistActivity as a param

//we must define a subcomponent factory inside this ArtistsSubComponent
//so that AppComponent knows how to create instances of this ArtistSubComponent
//we do this by creating an interface inside this interface.

@ArtistsScope
@Subcomponent(modules = [ArtistsModule::class])
interface ArtistsSubComponent {

     fun inject(artistsActivity: ArtistsActivity)

     @Subcomponent.Factory
     interface Factory{
         fun create() : ArtistsSubComponent
     }

}