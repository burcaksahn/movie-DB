package com.example.a29ekim.ui.favorite.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.a29ekim.utils.subscribeOnBackground


class FavRepository(val application:Application) {

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
        return favDao.getAllMovies()
    }
}