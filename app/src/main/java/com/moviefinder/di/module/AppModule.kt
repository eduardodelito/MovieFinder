package com.moviefinder.di.module

import dagger.Module


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
@Module(includes = [
    ClientModule::class,
])
class AppModule