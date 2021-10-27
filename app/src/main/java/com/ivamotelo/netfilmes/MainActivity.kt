package com.ivamotelo.netfilmes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ivamotelo.netfilmes.model.Movies
import com.ivamotelo.netfilmes.viewmodel.MoviesListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var moviesListViewModel: MoviesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesListViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesListViewModel::class.java)
        moviesListViewModel.init()
        initObserver()
        loadingVisibity(true)
    }

    private fun initObserver() {
        moviesListViewModel.moviesList.observe(this, Observer { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibity(false)
            }
        })
    }

    private fun populateList(list: List<Movies>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
    private fun loadingVisibity(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}