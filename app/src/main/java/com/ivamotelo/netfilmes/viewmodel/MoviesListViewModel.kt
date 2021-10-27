package com.ivamotelo.netfilmes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivamotelo.netfilmes.api.MoviesRestApiTask
import com.ivamotelo.netfilmes.model.Movies
import com.ivamotelo.netfilmes.repository.MoviesRepository

class MoviesListViewModel : ViewModel() {

    private val moviesRestApiTask = MoviesRestApiTask()
    private val moviesRepository = MoviesRepository(moviesRestApiTask)


    companion object {
        const val TAG = "MoviesRepository"
    }

    private var _moviesList = MutableLiveData<List<Movies>>() // LiveData mutável
    val moviesList: LiveData<List<Movies>>  // LiveData Imutável, estático -> apenas geters
        get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(moviesRepository.getAllMovies())
            } catch (exception: Exception) {
                    Log.d("TAG", exception.message.toString())
            }
        }
    }
}