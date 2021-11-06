package com.example.a29ekim.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentDetailBinding
import com.example.a29ekim.ui.movielist.MovieInfos
import com.example.a29ekim.ui.movielist.ResultInfo
import com.example.a29ekim.utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {

    private lateinit var api:GetService
    private lateinit var binding: FragmentDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

     private fun getDetail(bundle:Bundle){
         api= GetService.getInstance()
         var list:List<Example?>?=null
         Log.d("TAG", "getDetail: "+ DetailFragmentArgs.fromBundle(bundle).movieId.toInt())
         val call: Call<Example> = api.getSelectedMovie(
             DetailFragmentArgs.fromBundle(bundle).movieId.toInt()
         )
         call.enqueue(object : Callback<Example> {
             override fun onResponse(call: Call<Example>, response: Response<Example>) {
                 if (response.isSuccessful){
                     binding.movieIdText.setText(response.body()?.getId().toString())
                     binding.movieName.setText(response.body()?.getTitle().toString())
                     binding.overview.setText(response.body()?.getOverview().toString())
                     binding.vote.setText(response.body()?.getVoteCount().toString())
                     binding.voteaverage.setText(response.body()?.getVoteAverage().toString())
                     binding.releaseDate.setText(response.body()?.getReleaseDate().toString())
                     binding.status.setText(response.body()?.getStatus().toString())
                 }
                 Log.d("TAG", "onResponse: "+response.code())
                 Log.d("TAG", "onResponse: "+response.message())
             }

             override fun onFailure(call: Call<Example>, t: Throwable) {
                 Log.d("TAG", "onFailure:"+ t.toString())
             }

         })
     }


}