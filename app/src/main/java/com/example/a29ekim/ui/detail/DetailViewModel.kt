package com.example.a29ekim.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a29ekim.utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {
    private lateinit var api:GetService
     fun getDetail(bundle: Int):MutableLiveData<Example>{
        api= GetService.getInstance()
        var returnData= MutableLiveData<Example>()
        val call: Call<Example> = api.getSelectedMovie(
            bundle
        )
        call.enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                if (response.isSuccessful){
                    returnData.value=response.body()
                }
                Log.d("TAG", "onResponse: "+response.code())
                Log.d("TAG", "onResponse: "+response.message())
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Log.d("TAG", "onFailure:"+ t.toString())
            }

        })
         return returnData
    }
}