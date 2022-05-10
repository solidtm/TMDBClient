package com.solid.tmdbclient.data


import com.google.gson.annotations.SerializedName

//remember to make the properties null safe using ?
data class Artist(

    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for")
    val knownFor: List<KnownFor>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)