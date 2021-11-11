package com.example.a29ekim.ui.movielist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a29ekim.utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel :ViewModel() {
    private lateinit var api: GetService
     fun getData():MutableLiveData<List<ResultInfo>>{
        api= GetService.getInstance()
        var responseList=MutableLiveData<List<ResultInfo>>()
        val call: Call<MovieInfos> = api.getAllMovieList(1)
        call.enqueue(object : Callback<MovieInfos> {
            override fun onResponse(call: Call<MovieInfos>, response: Response<MovieInfos>) {
                if(response.isSuccessful){
                    responseList.value=response.body()?.results
                }
            }

            override fun onFailure(call: Call<MovieInfos>, t: Throwable) {
                Log.d("TAG", "onFailure:"+ t.toString())
            }

        })
        return responseList
    }

}