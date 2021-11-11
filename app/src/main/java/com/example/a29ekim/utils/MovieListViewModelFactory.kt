package com.example.a29ekim.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a29ekim.ui.movielist.MovieListViewModel

class MovieListViewModelFactory () :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel() as T
    }
}