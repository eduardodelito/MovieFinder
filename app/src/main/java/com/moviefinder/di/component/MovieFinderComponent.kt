package com.moviefinder.di.component

import android.app.Application
import com.moviefinder.di.module.ActivityBindingModule
import com.moviefinder.di.module.AppModule
import com.moviefinder.di.module.ClientModule
import com.moviefinder.di.module.ViewModelBindingModule
import com.moviefinder.ui.MovieFinderApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBindingModule::class,
    ViewModelBindingModule::class,
    AppModule::class
])
interface MovieFinderComponent : AndroidInjector<MovieFinderApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun client(clientModule: ClientModule): Builder
        fun build(): MovieFinderComponent
    }
}