package com.example.a29ekim.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a29ekim.ui.favorite.FavViewModel
import com.example.a29ekim.ui.movielist.MovieListViewModel

class FavViewModelFactory (val application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavViewModel(application) as T
    }
}