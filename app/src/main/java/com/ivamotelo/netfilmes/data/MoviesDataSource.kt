package com.ivamotelo.netfilmes.data

import com.ivamotelo.netfilmes.domain.Movies

interface MoviesDataSource {
    fun getAllMovies() : List<Movies>
}