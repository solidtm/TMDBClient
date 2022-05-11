package com.solid.tmdbclient.data.repository.artists.datasourceImpl

import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsCacheDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

//Her ewe are using a very basic caching mechanism using an arraylist of Movie instances.
class ArtistsCacheDataSourceImpl : ArtistsCacheDataSource {

    //cache
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}