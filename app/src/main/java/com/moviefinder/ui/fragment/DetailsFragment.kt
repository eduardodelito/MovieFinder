package com.moviefinder.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.moviefinder.ui.BR
import com.moviefinder.ui.R
import com.moviefinder.ui.common.fragment.BaseFragment
import com.moviefinder.ui.common.util.reObserve
import com.moviefinder.ui.databinding.DetailsFragmentBinding
import com.moviefinder.ui.state.LoadSelectedMovieItem
import com.moviefinder.ui.state.NoResultFound
import com.moviefinder.ui.state.SelectedMovieState
import com.moviefinder.ui.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.details_fragment.*
import javax.inject.Inject

class DetailsFragment : BaseFragment<DetailsFragmentBinding, DetailsViewModel>() {

    companion object {
        const val IMDB_ID = "imdbID"
        fun newInstance() = DetailsFragment()
    }

    @Inject
    override lateinit var viewModel: DetailsViewModel

    override fun createLayout() = R.layout.details_fragment

    override fun getBindingVariable() = BR.detailsViewModel

    override fun initViews() {
        arguments?.getString(IMDB_ID)?.let { viewModel.loadSelectedMovieItem(it) }
    }

    override fun subscribeUi() {
        with(viewModel) {
            reObserve(getSelectedMovieItemLiveData(), ::onSelectedMovieItemStateChanged)
        }
    }

    private fun onSelectedMovieItemStateChanged(state: SelectedMovieState?) {
        when (state) {
            is LoadSelectedMovieItem -> {
                val selectedMovieResponse = state.selectedMovieResponse
                movie_image.setImageURI(selectedMovieResponse.poster)
                movie_title.text = "Title: ${selectedMovieResponse.title}"
                movie_plot.text = "Plot: ${selectedMovieResponse.plot}"
                movie_language.text = "Language: ${selectedMovieResponse.language}"
                movie_actors.text = "Actors: ${selectedMovieResponse.actors}"
                movie_duration.text = "Duration: ${selectedMovieResponse.runtime}"
            }

            is NoResultFound -> {
                Toast.makeText(activity, state.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
