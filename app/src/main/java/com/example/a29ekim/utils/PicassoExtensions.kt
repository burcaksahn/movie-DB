package com.example.a29ekim.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

fun ImageView.updateWithUrl(url: String, imageViewAvatar: ImageView) {
    if (!url.isEmpty()){

        Picasso.get()
            .load(url)
            .resize(150,150)
            .into(imageViewAvatar)
    }
}