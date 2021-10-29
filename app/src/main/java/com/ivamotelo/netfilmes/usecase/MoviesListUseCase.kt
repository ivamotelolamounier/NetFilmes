package com.ivamotelo.netfilmes.usecase

import com.ivamotelo.netfilmes.data.MoviesRepository

class MoviesListUseCase(private val moviesRepository: MoviesRepository) {
    operator fun invoke() = moviesRepository.getAllMoviesFromDataSource()
}