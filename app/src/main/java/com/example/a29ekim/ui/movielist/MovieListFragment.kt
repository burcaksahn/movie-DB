package com.example.a29ekim.ui.movielist

import android.os.Bundle
import android.text.Layout
import android.util.Log
import retrofit2.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentMovieListBinding
import com.example.a29ekim.ui.home.HomeFragmentDirections
import com.example.a29ekim.utils.ListClickListener
import com.example.a29ekim.utils.GetService
import com.example.a29ekim.utils.RecyclerAdapter
import retrofit2.Callback
import retrofit2.Response

class MovieListFragment : Fragment(), ListClickListener {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var adapterMovie: RecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMovieListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialRecyclerView()
        getData()
        super.onViewCreated(view, savedInstanceState)

    }
    private fun initialRecyclerView(){
        adapterMovie= RecyclerAdapter(this)
        binding.rvmovie.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adapterMovie
        }
    }
    private lateinit var api:GetService
    private fun getData(){
        api=GetService.getInstance()
        var list:List<ResultInfo?>?=null
        val call: Call<MovieInfos> = api.getAllMovieList("22574df9e1fe27a06f9bce371fb6aa2a", 1)
        call.enqueue(object :Callback<MovieInfos>{
            override fun onResponse(call: Call<MovieInfos>, response: Response<MovieInfos>) {

                adapterMovie.submitList(response.body()?.results)
            }

            override fun onFailure(call: Call<MovieInfos>, t: Throwable) {
                Log.d("TAG", "onFailure:"+ t.toString())
            }

        })
    }

    override fun isClicked(id: String) {
        val action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(id.toInt())
        Navigation.findNavController(binding.root).navigate(action)
    }
}