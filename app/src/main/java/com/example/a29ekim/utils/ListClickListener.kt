package com.example.a29ekim.utils

import com.example.a29ekim.ui.favorite.FavViewModel
import com.example.a29ekim.ui.favorite.db.FavModel

interface ListClickListener {

    fun isClicked(id:String)
    fun isCheckFav(model: FavModel)
}