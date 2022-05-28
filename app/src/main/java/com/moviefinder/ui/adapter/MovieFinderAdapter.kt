package com.moviefinder.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.moviefinder.ui.R
import com.moviefinder.ui.client.model.MovieItem
import com.moviefinder.ui.databinding.ItemMovieFinderBinding


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
class MovieFinderAdapter(private val listener: MovieFinderAdapterListener) : RecyclerView.Adapter<MovieFinderAdapter.MovieFinderViewHolder>() {

    private var list = listOf<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFinderViewHolder {
        val itemMovieFinderBinding: ItemMovieFinderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie_finder, parent, false
        )

        return MovieFinderViewHolder(itemMovieFinderBinding)
    }

    override fun onBindViewHolder(holder: MovieFinderViewHolder, position: Int) {
        holder.itemMovieFinderBinding.movieFinderItem = list[position]
        holder.itemMovieFinderBinding.executePendingBindings()
        holder.itemMovieFinderBinding.itemLayout.setOnClickListener {
            listener.onMovieSelected(it, list[position].imdbID)
        }
    }

    override fun getItemCount() = list.size

    fun updateList(list: List<MovieItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MovieFinderViewHolder(val itemMovieFinderBinding: ItemMovieFinderBinding) :
        RecyclerView.ViewHolder(itemMovieFinderBinding.root)

    interface MovieFinderAdapterListener {
        fun onMovieSelected(view: View, imdbID: String?)
    }
}
