package com.solid.tmdbclient.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.solid.tmdbclient.R
import com.solid.tmdbclient.databinding.ActivityArtistsBinding

class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
    }
}