package com.example.tabebi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tabebi.fragments.FragmentFirst
import com.example.tabebi.fragments.FragmentSecond


class ViewPagerFragmentAdapter(activity: FragmentActivity) :  FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> FragmentFirst()
            1 -> FragmentSecond()
            else -> FragmentFirst()
        }
    }
}