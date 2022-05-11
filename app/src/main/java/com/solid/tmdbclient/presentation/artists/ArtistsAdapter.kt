package com.solid.tmdbclient.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solid.tmdbclient.R
import com.solid.tmdbclient.data.model.artists.Artist
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.model.tv_show.TvShow
import com.solid.tmdbclient.databinding.ListItemBinding

class ArtistsAdapter : RecyclerView.Adapter<ArtistsViewHolder>(){

    private val artistsList = ArrayList<Artist>()

    fun setList(artists: List<Artist>){
        artistsList.clear()
        artistsList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return ArtistsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }

    override fun getItemCount(): Int {
        return artistsList.size
    }
}

class ArtistsViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(artist: Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500" + artist.profilePath

        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}
