package com.moviefinder.ui.client.service

import com.moviefinder.ui.client.model.MovieFinderResponse
import com.moviefinder.ui.client.model.SelectedMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
interface APIService {
    @GET(".")
    fun fetchSearchMovies(
        @Query("apikey") apiKey: String,
        @Query("i") i: String,
        @Query("s") search: String
    ): Call<MovieFinderResponse>

    @GET(".")
    fun fetchSelectedMovie(
        @Query("apikey") apiKey: String,
        @Query("i") i: String
    ): Call<SelectedMovieResponse>
}