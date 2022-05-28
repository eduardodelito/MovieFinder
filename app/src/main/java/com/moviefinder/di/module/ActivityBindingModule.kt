package com.moviefinder.di.module

import com.moviefinder.di.module.ui.UIBindingModule
import com.moviefinder.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [
        UIBindingModule::class
    ])
    abstract fun bindMainActivity() : MainActivity
}
