package com.moviefinder.ui.client.service

import com.moviefinder.ui.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
class APIClient(val client: OkHttpClient) {
    private fun getRetrofitInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(BuildConfig.BASE_HTTP_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    /**
     * Instance call for the retrofit service.
     */
    fun getAPIServiceInstance(): APIService {
        val retrofit = getRetrofitInstance()
        return retrofit.create(APIService::class.java)
    }
}