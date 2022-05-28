package com.moviefinder.di.module.ui

import androidx.lifecycle.ViewModelProvider
import com.moviefinder.ui.common.viewmodel.ViewModelFactory
import com.moviefinder.ui.fragment.DetailsFragment
import com.moviefinder.ui.fragment.ListFragment
import com.moviefinder.ui.viewmodel.DetailsViewModel
import com.moviefinder.ui.viewmodel.ListViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Module
abstract class UIBindingModule {
    @ContributesAndroidInjector(modules = [InjectListViewModelModule::class])
    abstract fun bindListFragment(): ListFragment

    @Module
    class InjectListViewModelModule {
        @Provides
        internal fun provideListViewModel(
            factory: ViewModelProvider.Factory,
            target: ListFragment
        ) = ViewModelProvider(target, factory)[ListViewModel::class.java]
    }

    @ContributesAndroidInjector(modules = [InjectDetailsViewModelModule::class])
    abstract fun bindDetailsFragment(): DetailsFragment

    @Module
    class InjectDetailsViewModelModule {
        @Provides
        internal fun provideDetailsViewModel(
            factory: ViewModelProvider.Factory,
            target: DetailsFragment
        ) = ViewModelProvider(target, factory)[DetailsViewModel::class.java]
    }
}
