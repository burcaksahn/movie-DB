package com.example.a29ekim.ui.movielist

import android.os.Bundle
import android.util.Log
import retrofit2.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29ekim.R
import com.example.a29ekim.utils.GetService
import retrofit2.Callback
import retrofit2.Response

class MovieListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private lateinit var api:GetService
    private fun getData(){
        api=GetService.getInstance()
        var list:List<Result?>?=null
        val call: Call<MovieInfos> = api.getAllMovieList("22574df9e1fe27a06f9bce371fb6aa2a", 1)
        call.enqueue(object :Callback<MovieInfos>{
            override fun onResponse(call: Call<MovieInfos>, response: Response<MovieInfos>) {
                Log.d("TAG", "onResponse: "+response.body()?.results?.get(0)?.title)
            }

            override fun onFailure(call: Call<MovieInfos>, t: Throwable) {
            }
        })
    }
}