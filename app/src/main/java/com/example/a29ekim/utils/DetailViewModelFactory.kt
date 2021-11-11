package com.example.a29ekim.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a29ekim.ui.detail.DetailViewModel


class DetailViewModelFactory () :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel() as T
    }
}