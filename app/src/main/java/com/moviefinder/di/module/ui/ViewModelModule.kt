package com.moviefinder.di.module.ui

import androidx.lifecycle.ViewModel
import com.moviefinder.ui.client.ClientRepository
import com.moviefinder.ui.common.viewmodel.ViewModelKey
import com.moviefinder.ui.viewmodel.DetailsViewModel
import com.moviefinder.ui.viewmodel.ListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Module
class ViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun provideListViewModel(clientRepository: ClientRepository): ViewModel =
        ListViewModel(clientRepository)

    @Provides
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun provideDetailsViewModel(clientRepository: ClientRepository): ViewModel =
        DetailsViewModel(clientRepository)
}
