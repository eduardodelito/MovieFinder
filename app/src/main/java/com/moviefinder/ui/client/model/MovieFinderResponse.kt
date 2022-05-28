package com.moviefinder.ui.client.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
data class MovieFinderResponse(
    @SerializedName("Search")
    @Expose var search: List<MovieItem>? = null,

    @SerializedName("totalResults")
    @Expose var totalResults: String? = null,

    @SerializedName("Response")
    @Expose var response: String? = null
)

data class MovieItem(
    @SerializedName("Title")
    @Expose var title: String? = null,

    @SerializedName("Year")
    @Expose var year: String? = null,

    @SerializedName("imdbID")
    @Expose var imdbID: String? = null,

    @SerializedName("Type")
    @Expose var type: String? = null,

    @SerializedName("Poster")
    @Expose var poster: String? = null
)
