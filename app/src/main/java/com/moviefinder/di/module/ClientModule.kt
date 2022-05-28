package com.moviefinder.di.module

import com.moviefinder.ui.client.ClientRepository
import com.moviefinder.ui.client.ClientRepositoryImpl
import com.moviefinder.ui.client.service.APIClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Module
class ClientModule {
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideVPRetrofitClient(okHttpClient: OkHttpClient) =
        APIClient(okHttpClient)

    @Provides
    @Singleton
    fun provideClientRepository(apiClient: APIClient): ClientRepository =
        ClientRepositoryImpl(apiClient)
}
