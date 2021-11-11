package com.example.a29ekim.ui.favorite.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(model: FavModel)

    @Delete
    fun delete(model: FavModel)

    @Query("SELECT * FROM fav_table ORDER BY name DESC")
    fun getAllMovies():LiveData<List<FavModel>>

}