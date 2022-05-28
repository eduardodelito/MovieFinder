package com.moviefinder.ui.viewmodel

import com.moviefinder.ui.BuildConfig
import com.moviefinder.ui.client.ClientRepository
import com.moviefinder.ui.common.util.SingleLiveEvent
import com.moviefinder.ui.common.viewmodel.BaseViewModel
import com.moviefinder.ui.state.LoadDataItems
import com.moviefinder.ui.state.MovieFinderState
import com.moviefinder.ui.state.NoResults
import com.moviefinder.ui.state.ShowLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ListViewModel @Inject constructor(private val clientRepository: ClientRepository) :
    BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val movieItemState = SingleLiveEvent<MovieFinderState>()
    internal fun getDataItemLiveData(): SingleLiveEvent<MovieFinderState> =
        movieItemState

    fun onQueryTextSubmit(query: String?) {
        query?.let {
            if (it.isNotEmpty()) {
                movieItemState.postValue(ShowLoader(true))
                launch {
                    fetchDataFromService(it)
                }
            }
        }
    }

    private suspend fun fetchDataFromService(query: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = clientRepository.fetchSearchMovies(BuildConfig.API_KEY, BuildConfig.MY_IMDB_ID, query)
                if (result != null) {
                    val list = result.search
                    if (!list.isNullOrEmpty()) {
                        movieItemState.postValue(LoadDataItems(list))
                    } else {
                        movieItemState.postValue(NoResults("No results found. Please try again."))
                    }
                } else {
                    movieItemState.postValue(NoResults("No results found. Please try again."))
                }
            } catch (e: Exception) {
                movieItemState.postValue(NoResults("No results found. Please try again."))
                e.printStackTrace()
            }
        }
    }
}
