package com.solid.tmdbclient.data.model.artists


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//remember to make the properties null safe using ?
//using the same class as Entity for DB

@Entity(tableName = "popular_artists")
data class Artist(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)