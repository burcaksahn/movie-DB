package com.example.a29ekim.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.a29ekim.ui.favorite.FavFragment
import com.example.a29ekim.ui.movielist.MovieListFragment

class ViewPagerAdapter (val fragmentManager: FragmentManager, internal var totalTabs:Int) :FragmentPagerAdapter(fragmentManager
){
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        var fragment:Fragment=Fragment()
        if (position==0){
            fragment=MovieListFragment()
        }
        else if(position==1){
            fragment=FavFragment()
        }
        return fragment

    }
}