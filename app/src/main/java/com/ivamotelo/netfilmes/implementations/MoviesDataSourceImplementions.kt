package com.ivamotelo.netfilmes.implementations

import android.util.Log
import com.ivamotelo.netfilmes.data.MoviesDataSource
import com.ivamotelo.netfilmes.domain.Movies
import com.ivamotelo.netfilmes.flameworks.api.MoviesRestApiTask

class MoviesDataSourceImplementations(private val moviesRestApiTask: MoviesRestApiTask) : MoviesDataSource {

    companion object {
        const val TAG = "MoviesRepository"
    }

    private val moviesList = arrayListOf<Movies>()

    override fun getAllMovies(): List<Movies> {
        val request = moviesRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                moviesList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return moviesList
    }
}