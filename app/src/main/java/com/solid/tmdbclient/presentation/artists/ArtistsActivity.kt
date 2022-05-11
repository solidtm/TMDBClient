package com.solid.tmdbclient.presentation.artists

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.solid.tmdbclient.R
import com.solid.tmdbclient.databinding.ActivityArtistsBinding
import com.solid.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistsViewModelFactory

    private lateinit var binding: ActivityArtistsBinding

    private lateinit var artistsViewModel: ArtistsViewModel
    private lateinit var artistsAdapter : ArtistsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)

        //with this, we can inject dependencies to this activities.
        (application as Injector).createArtistsSubComponent()
            .inject(this)

        artistsViewModel = ViewModelProvider(this, factory)
            .get(ArtistsViewModel::class.java)

        initRecyclerView()
    }


    //inflating the update icon
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE

        val response = artistsViewModel.updateArtistsList()
        response.observe(this, Observer {
            if (it != null){
                artistsAdapter.setList(it)
                artistsAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }

    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistsAdapter = ArtistsAdapter()
        binding.artistRecyclerView.adapter = artistsAdapter

        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE

        val responseLiveData = artistsViewModel.getArtists()

        responseLiveData.observe(this, Observer{
            if (it != null){
                artistsAdapter.setList(it)
                artistsAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}