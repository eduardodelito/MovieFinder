package com.moviefinder.ui.state

import com.moviefinder.ui.client.model.MovieItem


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
sealed class MovieFinderState
data class LoadDataItems(val items: List<MovieItem>) : MovieFinderState()
data class NoResults(val message: String) : MovieFinderState()
data class ShowLoader(val show: Boolean) : MovieFinderState()
