package com.moviefinder.ui.viewmodel

import com.moviefinder.ui.BuildConfig
import com.moviefinder.ui.client.ClientRepository
import com.moviefinder.ui.common.util.SingleLiveEvent
import com.moviefinder.ui.common.viewmodel.BaseViewModel
import com.moviefinder.ui.state.LoadSelectedMovieItem
import com.moviefinder.ui.state.NoResultFound
import com.moviefinder.ui.state.SelectedMovieState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailsViewModel @Inject constructor(val clientRepository: ClientRepository) :
    BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val selectedMovieItemState = SingleLiveEvent<SelectedMovieState>()
    internal fun getSelectedMovieItemLiveData(): SingleLiveEvent<SelectedMovieState> =
        selectedMovieItemState

    fun loadSelectedMovieItem(imdbID: String) {
        launch {
            loadSelectedMovieItemFromService(imdbID)
        }
    }

    private suspend fun loadSelectedMovieItemFromService(imdbID: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = clientRepository.loadSelectedMovieItem(BuildConfig.API_KEY, imdbID)
                if (result != null) {
                    selectedMovieItemState.postValue(LoadSelectedMovieItem(result))
                } else {
                    selectedMovieItemState.postValue(NoResultFound("The selected item not found."))
                }
            } catch (e: Exception) {
                selectedMovieItemState.postValue(NoResultFound("The selected item not found."))
                e.printStackTrace()
            }
        }
    }
}
