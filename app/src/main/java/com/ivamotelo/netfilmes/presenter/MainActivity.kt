/**
 * ARQUITETURA MVVM
 * MÓDULOS:
 * domain -> Modelos e regras de negócios
 * data -> Abstração para acessar o datasource
 * usecase -> Transmite as ações aos usuários (invoca o repository e o datasource para a ação de busca)
 * implementations -> Implementa o datasource e executa a pesquisa da lista
 * app (flamewors) -> Contém as implementações das interfaces da camada de dados (requisiçoes,
 * tratamento das regras de negócio e exibição)
 *
 * https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList
 * https://github.com/natanfelipe/FilmesFlix/tree/aula_4_codificacao
 * https://github.com/natanfelipe/FilmesFlix/tree/aula_5_codificacao
 * https://github.com/natanfelipe/FilmesFlix/tree/aula_6_codificacao
 */
package com.ivamotelo.netfilmes.presenter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ivamotelo.netfilmes.R
import com.ivamotelo.netfilmes.domain.Movies
import com.ivamotelo.netfilmes.flameworks.viewmodel.MoviesListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var moviesListViewModel: MoviesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesListViewModel = ViewModelProvider.NewInstanceFactory().create(MoviesListViewModel::class.java)
        moviesListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        moviesListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movies>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}