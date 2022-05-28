package com.moviefinder.ui.client.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
data class SelectedMovieResponse(
    @SerializedName("Title")
    @Expose var title: String? = null,

    @SerializedName("Year")
    @Expose var year: String? = null,

    @SerializedName("Poster")
    @Expose var poster: String? = null,

    @SerializedName("Plot")
    @Expose var plot: String? = null,

    @SerializedName("Language")
    @Expose var language: String? = null,

    @SerializedName("Actors")
    @Expose var actors: String? = null,

    @SerializedName("Runtime")
    @Expose var runtime: String? = null
)
