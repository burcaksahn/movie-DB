package com.example.a29ekim.ui.favorite.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_table")
data class FavModel(
    @PrimaryKey
    val name:String,
    val movieNumber:Int,
    val posterPath:String)