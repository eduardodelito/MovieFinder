package com.moviefinder.ui.state

import com.moviefinder.ui.client.model.SelectedMovieResponse


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
sealed class SelectedMovieState
data class LoadSelectedMovieItem(val selectedMovieResponse: SelectedMovieResponse) :
    SelectedMovieState()

data class NoResultFound(val message: String) : SelectedMovieState()