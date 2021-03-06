package com.example.tabebi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.tabebi.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager2 : ViewPager2
    private lateinit var viewPagerFragmentAdapter : ViewPagerFragmentAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        viewPager2.adapter = viewPagerFragmentAdapter
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            tab.text =  "tab${position+1}"
            when(position) {
                0 -> {
                    tab.text = "First Gear"
                }
                1 -> {
                    tab.text = "Gear secando"
                }
                2 -> {
                    tab.text = "Gear notes"
                }

            }

        }.attach()
    }

    private fun init(){
        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
    }

}