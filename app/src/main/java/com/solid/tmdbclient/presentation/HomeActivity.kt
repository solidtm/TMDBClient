package com.solid.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.solid.tmdbclient.R
import com.solid.tmdbclient.databinding.ActivityHomeBinding
import com.solid.tmdbclient.presentation.artists.ArtistsActivity
import com.solid.tmdbclient.presentation.movie.MovieActivity
import com.solid.tmdbclient.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
    }
}