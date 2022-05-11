package com.solid.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.solid.tmdbclient.R
import com.solid.tmdbclient.databinding.ActivityTvShowBinding
import com.solid.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory

    private lateinit var binding: ActivityTvShowBinding

    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var tvShowAdapter : TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)


        //with this, we can inject dependencies to this activities.
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)

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
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        binding.tvProgressBar.visibility = View.VISIBLE

        val response = tvShowViewModel.updateTvShowList()
        response.observe(this, Observer {
            if (it != null){
                tvShowAdapter.setList(it)
                tvShowAdapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            }
        })
    }

    private fun initRecyclerView(){
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TvShowAdapter()
        binding.tvRecyclerView.adapter = tvShowAdapter

        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvProgressBar.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.getTvShows()

        responseLiveData.observe(this, Observer{
            if (it != null){
                tvShowAdapter.setList(it)
                tvShowAdapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            }else{
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}