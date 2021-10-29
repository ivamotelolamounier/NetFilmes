package com.ivamotelo.netfilmes.flameworks.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivamotelo.netfilmes.flameworks.api.MoviesRestApiTask
import com.ivamotelo.netfilmes.data.MoviesRepository
import com.ivamotelo.netfilmes.domain.Movies
import com.ivamotelo.netfilmes.implementations.MoviesDataSourceImplementations
import com.ivamotelo.netfilmes.usecase.MoviesListUseCase

class MoviesListViewModel : ViewModel() {

    companion object {
        const val TAG = "MoviesRepository"
    }

    private val moviesRestApiTask = MoviesRestApiTask()
    private val moviesDataSource = MoviesDataSourceImplementations(moviesRestApiTask)
    private val moviesRepository = MoviesRepository(moviesDataSource)
    private val moviesListUseCase = MoviesListUseCase(moviesRepository)

    private var _moviesList = MutableLiveData<List<Movies>>() // LiveData mutável
    val moviesList: LiveData<List<Movies>>  // LiveData Imutável, estático -> apenas geters
        get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            } catch (exception: Exception) {
                    Log.d("TAG", exception.message.toString())
            }
        }.start()
    }
}