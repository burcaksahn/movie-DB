package com.example.a29ekim.ui.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a29ekim.ui.favorite.db.FavModel
import com.example.a29ekim.ui.favorite.db.FavRepository

class FavViewModel(application: Application) : ViewModel() {
    private val repository=FavRepository(application)
    fun insert(model: FavModel){
        repository.insert(model)
    }
    fun delete(model:FavModel){
        repository.delete(model)
    }
    fun getAllMovies():LiveData<List<FavModel>>{
        return repository.getAllMovies()
    }
}