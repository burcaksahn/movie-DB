package com.example.a29ekim.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a29ekim.R
import com.example.a29ekim.ui.favorite.db.FavModel
import com.example.a29ekim.ui.movielist.ResultInfo

class RecyclerAdapter(val listener:ListClickListener) : ListAdapter<ResultInfo, RecyclerAdapter.UserHolder>(
    diffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie_list, parent,
            false)
        return UserHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val currentUser = getItem(position)
        holder.movieName.text = currentUser.title
        holder.movieImage.updateWithUrl("https://image.tmdb.org/t/p/w500/"+currentUser.posterPath,holder.movieImage)
        Log.d("TAG", "onBindViewHolder: "+"https://image.tmdb.org/t/p/w500/"+currentUser.posterPath)
    }

    inner class UserHolder(iv: View) : RecyclerView.ViewHolder(iv) {
        val movieName: TextView = itemView.findViewById(R.id.movieName)
        val movieImage: ImageView = itemView.findViewById(R.id.moviePhoto)
        val movieIsFav: ImageView = itemView.findViewById(R.id.listArrow)
        init {
            movieName.setOnClickListener{
                if(adapterPosition!=RecyclerView.NO_POSITION){
                    listener.isClicked(getItem(adapterPosition).id.toString())
                }
            }
            movieIsFav.setOnClickListener{
                if(adapterPosition!=RecyclerView.NO_POSITION){
                    listener.isCheckFav(FavModel(getItem(adapterPosition).title.toString()))
                }

            }
        }
    }

}

private val diffCallback = object : DiffUtil.ItemCallback<ResultInfo>() {
    override fun areItemsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
        return oldItem.title.equals(newItem.title)
    }

    override fun areContentsTheSame(
        oldItem: ResultInfo,
        newItem: ResultInfo
    ): Boolean {
        return oldItem.originalTitle.equals(newItem.originalTitle)
    }
}