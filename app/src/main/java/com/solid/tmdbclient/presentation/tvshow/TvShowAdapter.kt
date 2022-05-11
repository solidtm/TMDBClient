package com.solid.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solid.tmdbclient.R
import com.solid.tmdbclient.data.model.movie.Movie
import com.solid.tmdbclient.data.model.tv_show.TvShow
import com.solid.tmdbclient.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>(){

    private val tvShowList = ArrayList<TvShow>()

    fun setList(movie: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TvShowViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath

        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}
