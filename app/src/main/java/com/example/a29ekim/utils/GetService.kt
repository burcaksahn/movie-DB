package com.example.a29ekim.utils

import com.example.a29ekim.ui.detail.Example
import com.example.a29ekim.ui.movielist.MovieInfos
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetService {
    @GET("/3/movie/popular?api_key=22574df9e1fe27a06f9bce371fb6aa2a")
    fun getAllMovieList(@Query("page")page:Int):Call<MovieInfos>
    @GET("/3/movie/{id}?api_key=22574df9e1fe27a06f9bce371fb6aa2a&language=en-US")
    fun getSelectedMovie(@Path("id") id: Int): Call<Example>
  //  https://api.themoviedb.org/3/movie/popular?api_key=22574df9e1fe27a06f9bce371fb6aa2a&language=en-US&page=1
    companion object{
        var retrofitService:GetService?=null
        fun getInstance():GetService{
            val gson=GsonBuilder().setLenient().create()
            if (retrofitService==null){
                var retrofit=Retrofit.Builder().baseUrl("https://api.themoviedb.org/").addConverterFactory(GsonConverterFactory.create(gson)).build()
            retrofitService=retrofit.create(GetService::class.java)
            }
        return retrofitService!!
        }
    }
}