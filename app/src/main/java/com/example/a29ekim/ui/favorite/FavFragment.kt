package com.example.a29ekim.ui.favorite

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentFavBinding
import com.example.a29ekim.ui.favorite.db.FavModel
import com.example.a29ekim.ui.movielist.MovieListViewModel
import com.example.a29ekim.utils.*


class FavFragment : Fragment(), ListClickListener {

    private lateinit var VM:FavViewModel
    private lateinit var binding:FragmentFavBinding
    private lateinit var adapterFav:FavAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFavBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun initialVM() {
        val factory =FavViewModelFactory(Application())
       //VM = ViewModelProvider(this, factory)[FavViewModel::class.java]
        VM=ViewModelProviders.of(this)[FavViewModel::class.java]

    }
    private fun initialRecyclerView(){
        adapterFav= FavAdapter(this)
        binding.rvfav.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adapterFav
        }
        VM.getAllMovies().observe(viewLifecycleOwner, Observer {
            adapterFav.submitList(it)
        })
    }

    private fun getData(){
        VM.getAllMovies().observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "getData: "+it.size)
            for (i in 0..it.size-1){
                Log.d("TAG", "getData:"+ it.get(i).name)
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialVM()
        initialRecyclerView()
        getData()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun isClicked(id: String) {

    }

    override fun isCheckFav(model: FavModel) {

    }

}