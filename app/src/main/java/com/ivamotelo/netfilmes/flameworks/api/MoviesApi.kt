package com.ivamotelo.netfilmes.flameworks.api

import com.ivamotelo.netfilmes.domain.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {

    // Rota da consulta
    // https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies() : Call<List<Movies>>
}