package com.solid.tmdbclient.data.repository

import android.util.Log
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.model.tv_show.TvShow
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.solid.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.solid.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl (
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
         val newListOfTvShows = getTvShowsFromAPI()
         tvShowLocalDataSource.clearAll()
         tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
         tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }


    //functions to get tv shows from API
    private suspend fun getTvShowsFromAPI() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()

            if (body != null){
                tvShowList = body.tvShows    //response from API comes as a Movie list object
            }

        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        return tvShowList
    }


    //function to get tv shows from DB
    private suspend fun getTvShowsFromDB() : List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        //check movieList
        if (tvShowList.isNotEmpty()){  //means there are movie data available, just return it
            return tvShowList
        }else{  //we fetch movies from remote source and save to DB
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }


    //function to get tv shows from cache
    private suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        //get data from the API and
        //assign movies taken from the api to this list and return it.
        try{
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (ex: Exception){
            Log.i("MyTag", ex.message.toString())
        }

        //check movieList
        if (tvShowList.isNotEmpty()){  //means there are movie data available, just return it
            return tvShowList
        }else{  //we fetch movies from database and save to cache
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}