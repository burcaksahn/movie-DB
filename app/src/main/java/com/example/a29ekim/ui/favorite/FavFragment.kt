package com.example.a29ekim.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentFavBinding


class FavFragment : Fragment() {

    private lateinit var VM:FavViewModel
    private lateinit var binding:FragmentFavBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFavBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun initialVM(){
       VM=ViewModelProviders.of(this)[FavViewModel::class.java]
    }
    private fun getData(){
        VM.getAllMovies().observe(viewLifecycleOwner, Observer {  })
    }

}