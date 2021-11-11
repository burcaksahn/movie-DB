package com.example.a29ekim.ui.movielist

import android.os.Bundle
import android.text.Layout
import android.util.Log
import retrofit2.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentMovieListBinding
import com.example.a29ekim.ui.home.HomeFragmentDirections
import com.example.a29ekim.utils.ListClickListener
import com.example.a29ekim.utils.GetService
import com.example.a29ekim.utils.MovieListViewModelFactory
import com.example.a29ekim.utils.RecyclerAdapter
import retrofit2.Callback
import retrofit2.Response

class MovieListFragment : Fragment(), ListClickListener {

    private lateinit var VM:MovieListViewModel
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
    private fun initialVM() {
        val factory = MovieListViewModelFactory()
        VM = ViewModelProvider(this, factory)[MovieListViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialVM()
        initialRecyclerView()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initialRecyclerView(){
        adapterMovie= RecyclerAdapter(this)
        binding.rvmovie.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adapterMovie
        }
        VM.getData().observe(viewLifecycleOwner, Observer {
            adapterMovie.submitList(it)
        })
    }
    override fun isClicked(id: String) {
        val action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(id.toInt())
        Navigation.findNavController(binding.root).navigate(action)
    }
}