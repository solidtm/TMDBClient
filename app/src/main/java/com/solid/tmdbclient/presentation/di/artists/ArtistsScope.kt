package com.solid.tmdbclient.presentation.di.artists

import javax.inject.Scope

//Scope class for providing ArtistsViewModelFactory dependency to be scoped to runtime only.

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ArtistsScope