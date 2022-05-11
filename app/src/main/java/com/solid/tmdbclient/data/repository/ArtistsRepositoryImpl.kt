package com.solid.tmdbclient.data.repository

import android.util.Log
import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsCacheDataSource
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsLocalDataSource
import com.solid.tmdbclient.data.repository.artists.datasource.ArtistsRemoteDataSource
import com.solid.tmdbclient.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl(
    private val artistsRemoteDataSource: ArtistsRemoteDataSource,
    private val artistsLocalDataSource: ArtistsLocalDataSource,
    private val artistsCacheDataSource: ArtistsCacheDataSource
) : ArtistsRepository{
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistsFromAPI()
        artistsLocalDataSource.clearAll()
        artistsLocalDataSource.saveArtistsToDB(newArtistList)
        artistsCacheDataSource.saveArtistsToCache(newArtistList)

        return newArtistList
    }


    //functions to get artists from API
    private suspend fun getArtistsFromAPI() : List<Artist> {
        lateinit var artistsList: List<Artist>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            val response = artistsRemoteDataSource.getArtists()
            val body = response.body()

            if (body != null){
                artistsList = body.artists    //response from API comes as a Movie list object
            }

        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        return artistsList
    }


    //function to get artists from DB
    private suspend fun getArtistsFromDB() : List<Artist>{
        lateinit var artistsList: List<Artist>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            artistsList = artistsLocalDataSource.getArtistsFromDB()
        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        //check movieList
        if (artistsList.isNotEmpty()){  //means there are movie data available, just return it
            return artistsList
        }else{  //we fetch movies from remote source and save to DB
            artistsList = getArtistsFromAPI()
            artistsLocalDataSource.saveArtistsToDB(artistsList)
        }

        return artistsList
    }


    //function to get artists from cache
    private suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistsList: List<Artist>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            artistsList = artistsCacheDataSource.getArtistsFromCache()
        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        //check movieList
        if (artistsList.isNotEmpty()){  //means there are movie data available, just return it
            return artistsList
        }else{  //we fetch movies from database and save to cache
            artistsList = getArtistsFromDB()
            artistsCacheDataSource.saveArtistsToCache(artistsList)
        }

        return artistsList
    }
}