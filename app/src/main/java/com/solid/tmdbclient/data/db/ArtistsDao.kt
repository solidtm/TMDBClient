package com.solid.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.data.model.tv_show.TvShow

@Dao
interface ArtistsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(movies: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}