package com.solid.tmdbclient.data.repository.artists.datasourceImpl

import com.solid.tmdbclient.data.db.ArtistsDao
import com.solid.tmdbclient.data.db.MovieDao
import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsLocalDataSource
import com.solid.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalDataSourceImpl(private val artistDao: ArtistsDao) : ArtistsLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>){
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}