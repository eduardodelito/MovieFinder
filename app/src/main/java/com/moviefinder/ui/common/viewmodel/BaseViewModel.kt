package com.moviefinder.ui.common.viewmodel

import androidx.lifecycle.ViewModel


/**
 * Created by Eduardo Delito III on 5/28/22.
 * eduardo.delito@gmail.com
 */
abstract class BaseViewModel : ViewModel() {

    open fun onStart() {
    }

    open fun onResume() {
    }

    open fun onPause() {
    }

    open fun onStop() {
    }

    open fun onDestroy() {
    }
}
