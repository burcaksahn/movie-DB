package com.example.a29ekim.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.example.a29ekim.R
import com.example.a29ekim.databinding.FragmentHomeBinding
import com.example.a29ekim.utils.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        intialViewPager()
        super.onViewCreated(view, savedInstanceState)

    }

    private fun intialViewPager(){
        val adapter=ViewPagerAdapter(requireActivity().supportFragmentManager,2)
        binding.viewPagerId.adapter=adapter
        binding.viewPagerId.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
            binding.viewPagerId.currentItem=tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }


}