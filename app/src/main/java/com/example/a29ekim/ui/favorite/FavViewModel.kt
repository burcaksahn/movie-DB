package com.example.a29ekim.ui.favorite

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a29ekim.ui.favorite.db.FavModel
import com.example.a29ekim.ui.favorite.db.FavRepository

class FavViewModel(application: Application) : AndroidViewModel(application)
{
    private val repository=FavRepository(application)
    fun insert(model: FavModel){
        repository.insert(model)
    }
    fun delete(model:FavModel){
        repository.delete(model)
    }
    fun getAllMovies():LiveData<List<FavModel>>{
        Log.d("TAG", "getAllMovies: ")
        return repository.getAllMovies()
    }
}