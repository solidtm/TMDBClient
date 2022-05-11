package com.solid.tmdbclient.data.api

import com.solid.tmdbclient.data.model.artists.ArtistList
import com.solid.tmdbclient.data.model.movie.MovieList
import com.solid.tmdbclient.data.model.tv_show.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    //function to get list of popular movies, tv shows and artists
    //(we will use coroutines in the background, so suspend functions)

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String) : Response<ArtistList>
}