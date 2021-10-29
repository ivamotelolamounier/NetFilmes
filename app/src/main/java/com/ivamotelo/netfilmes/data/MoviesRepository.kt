package com.ivamotelo.netfilmes.data

class MoviesRepository(private val moviesDataSource: MoviesDataSource) {
    fun getAllMoviesFromDataSource() = moviesDataSource.getAllMovies()
}