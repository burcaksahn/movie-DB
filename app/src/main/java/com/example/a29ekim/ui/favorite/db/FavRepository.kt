package com.example.a29ekim.ui.favorite.db

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.a29ekim.utils.subscribeOnBackground


class FavRepository(application:Application) {

    private val database=FavDatabase.getInstance(application)
    private val favDao=database.favDao()

    fun insert(model:FavModel){
        subscribeOnBackground{
            favDao.insert(model)
    }
    }

    fun delete(model: FavModel){
        subscribeOnBackground {
            favDao.delete(model)
        }

    }

    fun getAllMovies() : LiveData<List<FavModel>>{
        Log.d("TAG", "getAllMovies: ")
        return favDao.getAllMovies()
    }
}