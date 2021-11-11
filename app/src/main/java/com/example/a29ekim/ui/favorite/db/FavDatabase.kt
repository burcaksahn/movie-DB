package com.example.a29ekim.ui.favorite.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [FavModel::class],version=1)
abstract class FavDatabase :RoomDatabase(){
    abstract fun favDao():DAO
    companion object{
        private var instance:FavDatabase?=null
        @Synchronized
        fun getInstance(c:Context):FavDatabase{
            if(instance==null){
                instance=Room.databaseBuilder(c.applicationContext,FavDatabase::class.java,"fav_movie")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build()
            }
        return instance!!
        }
        private val callback=object :Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }
        private fun populateDatabase(db:FavDatabase){
            val favDao=db.favDao()
        }
    }

}