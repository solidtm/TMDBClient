package com.solid.tmdbclient.presentation.di.movie

import javax.inject.Scope

//Scope class for providing MovieViewModelFactory dependency to be scoped to runtime only.

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class MovieScope