package java.io.nanodegree.popularmovies.feature.movie.presentation.movielist.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.nanodegree.andrea.popularmovies.feature.movie.R
import java.io.nanodegree.popularmovies.feature.movie.data.model.Movie
import java.util.*

/**
 * Created by Andrea Loddo (andrea@evenly.io) on 11.05.2018
 * for Evenly GmbH
 *
 *
 * Copyright (c) 2018 Evenly GmbH,
 * all rights reserved
 */
internal class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesAdapter.MovieItemViewHolder>() {

    private val movies: MutableList<Movie>

    init {
        movies = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.movie_item, parent, false)

        return MovieItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun setData(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    internal inner class MovieItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)
        var movie: Movie? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            this.movie = movie
            Picasso.get().load(movie.getFormattedImageThumbnailUrl()).into(moviePoster)
        }

        override fun onClick(v: View) {}
    }
}