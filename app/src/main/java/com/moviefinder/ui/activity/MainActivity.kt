package com.moviefinder.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.moviefinder.ui.R
import com.moviefinder.ui.fragment.ListFragment
import com.moviefinder.ui.fragment.ListFragmentDirections
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), ListFragment.ListFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun navigateToDetails(view: View, imdbID: String?) {
        view.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(imdbID))
    }
}
