package com.ivamotelo.netfilmes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ivamotelo.netfilmes.model.Movies
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(private val moviesList: List<Movies>) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout,parent,false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
        movieTitle.text = moviesList[position].title
        movieImage.load(moviesList[position].image) {
            placeholder(R.drawable.ic_baseline_panorama_24)
            fallback(R.drawable.ic_baseline_panorama_24)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size
}