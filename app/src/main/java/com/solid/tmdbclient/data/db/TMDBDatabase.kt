package com.solid.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.model.tv_show.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    abstract fun movieDao() : MovieDao
    abstract fun tvShowDao() : TVShowDao
    abstract fun artistsDao() : ArtistsDao
}