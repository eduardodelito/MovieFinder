package com.moviefinder.di.module

import androidx.lifecycle.ViewModelProvider
import com.moviefinder.di.module.ui.ViewModelModule
import com.moviefinder.ui.common.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Module(
    includes = [
        ViewModelModule::class
    ]
)
abstract class ViewModelBindingModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
