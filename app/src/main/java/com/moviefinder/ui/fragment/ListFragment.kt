package com.moviefinder.ui.fragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviefinder.ui.BR
import com.moviefinder.ui.R
import com.moviefinder.ui.adapter.MovieFinderAdapter
import com.moviefinder.ui.common.fragment.BaseFragment
import com.moviefinder.ui.common.util.hideKeyboard
import com.moviefinder.ui.common.util.reObserve
import com.moviefinder.ui.databinding.ListFragmentBinding
import com.moviefinder.ui.state.LoadDataItems
import com.moviefinder.ui.state.MovieFinderState
import com.moviefinder.ui.state.NoResults
import com.moviefinder.ui.state.ShowLoader
import com.moviefinder.ui.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.list_fragment.*
import javax.inject.Inject

class ListFragment : BaseFragment<ListFragmentBinding, ListViewModel>(),
    SearchView.OnQueryTextListener {

    companion object {
        fun newInstance() = ListFragment()
    }

    private var listener: ListFragmentListener? = null
    private lateinit var movieAdapter: MovieFinderAdapter

    @Inject
    override lateinit var viewModel: ListViewModel

    override fun createLayout() = R.layout.list_fragment

    override fun getBindingVariable() = BR.listViewModel

    override fun initViews() {
        movieAdapter = MovieFinderAdapter(object : MovieFinderAdapter.MovieFinderAdapterListener {
            override fun onMovieSelected(view: View, imdbID: String?) {
                listener?.navigateToDetails(view, imdbID)
            }
        })

        with(recycler_view) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
            adapter = movieAdapter
        }

        search_view.setOnQueryTextListener(this)
        var query = search_view.query
        viewModel.onQueryTextSubmit(query.toString())
    }

    override fun subscribeUi() {
        with(viewModel) {
            reObserve(getDataItemLiveData(), ::onMovieFinderItemStateChanged)
        }
    }

    private fun onMovieFinderItemStateChanged(state: MovieFinderState?) {
        when (state) {
            is LoadDataItems -> {
                progressBar.visibility = View.GONE
                no_available_data_view.visibility = View.GONE
                search_text_result.visibility = View.GONE
                hideKeyboard()
                movieAdapter.updateList(state.items)
            }

            is NoResults -> {
                progressBar.visibility = View.GONE
                search_text_result.text = state.message
                search_text_result.visibility = View.VISIBLE
                no_available_data_view.visibility = View.VISIBLE
            }

            is ShowLoader -> {
                progressBar.visibility = if (state.show) {
                    search_text_result.visibility = View.GONE
                    no_available_data_view.visibility = View.GONE
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        viewModel.onQueryTextSubmit(query)
        return true
    }

    override fun onQueryTextChange(newText: String?) = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListFragmentListener) {
            listener = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listener = null
    }

    interface ListFragmentListener {
        fun navigateToDetails(view: View, imdbID: String?)
    }
}
