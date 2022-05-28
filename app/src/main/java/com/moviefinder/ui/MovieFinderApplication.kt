package com.moviefinder.ui

import com.facebook.drawee.backends.pipeline.Fresco
import com.moviefinder.di.component.DaggerMovieFinderComponent
import com.moviefinder.di.module.ClientModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
class MovieFinderApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMovieFinderComponent.builder().application(this).client(ClientModule()).build()
    }
}
