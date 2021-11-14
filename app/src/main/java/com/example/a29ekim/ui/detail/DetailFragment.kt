package com.example.a29ekim.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentDetailBinding
import com.example.a29ekim.ui.movielist.MovieInfos
import com.example.a29ekim.ui.movielist.MovieListViewModel
import com.example.a29ekim.ui.movielist.ResultInfo
import com.example.a29ekim.utils.DetailViewModelFactory
import com.example.a29ekim.utils.GetService
import com.example.a29ekim.utils.MovieListViewModelFactory
import com.example.a29ekim.utils.updateWithUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {

    private lateinit var VM:DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialVM()
        arguments?.let {
            getDetail(it)

        }
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun initialVM() {
        val factory = DetailViewModelFactory()
        VM = ViewModelProvider(this, factory)[DetailViewModel::class.java]

    }


    private fun getDetail(bundle:Bundle) {
        VM.getDetail(DetailFragmentArgs.fromBundle(bundle).movieId).observe(viewLifecycleOwner,
            Observer {
                binding.movieIdText.setText(it.getId().toString())
                binding.movieName.setText(it.getTitle())
                binding.status.setText(it.getStatus().toString())
                binding.releaseDate.setText(it.getReleaseDate().toString())
                binding.voteaverage.setText(it.getVoteAverage().toString())
                binding.vote.setText(it.getVoteCount().toString())
                binding.overview.setText(it.getOverview().toString())
                binding.imageView2.updateWithUrl("https://image.tmdb.org/t/p/w500/"+it.getPosterPath(),binding.imageView2)

            })
         Log.d("TAG", "getDetail: " + DetailFragmentArgs.fromBundle(bundle).movieId.toInt())
     }

}