package com.solid.tmdbclient.presentation.di.tvshow

import javax.inject.Scope

//Scope class for providing TvShowViewModelFactory dependency to be scoped to runtime only.

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class TvShowScope