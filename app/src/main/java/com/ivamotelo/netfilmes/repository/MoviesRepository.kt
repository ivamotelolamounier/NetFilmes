package com.ivamotelo.netfilmes.repository

import android.util.Log
import com.ivamotelo.netfilmes.api.MoviesRestApiTask
import com.ivamotelo.netfilmes.model.Movies

class MoviesRepository(private val moviesRestApiTask: MoviesRestApiTask) {

    companion object {
        const val TAG = "MoviesRepository"
    }

    private val moviesList = arrayListOf<Movies>()

    fun getAllMovies() : List<Movies> {
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