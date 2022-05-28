package com.moviefinder.ui.client

import com.moviefinder.ui.client.model.MovieFinderResponse
import com.moviefinder.ui.client.model.SelectedMovieResponse
import com.moviefinder.ui.client.service.APIClient
import java.lang.Exception


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
interface ClientRepository {
    fun fetchSearchMovies(apiKey: String, imdbID: String, search: String): MovieFinderResponse?
    fun loadSelectedMovieItem(apiKey: String, imdbID: String, plot: String): SelectedMovieResponse?
}

class ClientRepositoryImpl(private val client: APIClient) : ClientRepository {
    override fun fetchSearchMovies(
        apiKey: String,
        imdbID: String,
        search: String
    ): MovieFinderResponse? {
        try {
            var res =
                client.getAPIServiceInstance().fetchSearchMovies(apiKey, imdbID, search).execute()
            if (res.isSuccessful) {
                return res.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun loadSelectedMovieItem(apiKey: String, imdbID: String, plot: String): SelectedMovieResponse? {
        try {
            var res =
                client.getAPIServiceInstance().fetchSelectedMovie(apiKey, imdbID, plot).execute()
            if (res.isSuccessful) {
                return res.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
