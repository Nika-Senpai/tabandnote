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

    private lateinit var editTextNote : EditText
    private lateinit var buttonAdd : Button
    private lateinit var textView : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("amateratsu", MODE_PRIVATE)
        val text = sharedPreferences.getString("shinigami", "bijo bijuna")

        init()
        textView.text = text
        buttonAdd.setOnClickListener {
            var note = editTextNote.text.toString()
            var text = textView.text.toString()
            var result = note + "\n" + text
            textView.text = result

            sharedPreferences.edit().putString("shinigami", result).apply()


        }




        viewPager2.adapter = viewPagerFragmentAdapter
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "First page"
                }
                1 -> {
                    tab.text = "Second page"
                }

            }

        }.attach()
    }


    private fun init() {
        tabLayout = findViewById(R.id. tabLayout)
        viewPager2 = findViewById(R.id. viewPager2)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        editTextNote = findViewById(R.id. editTextNote)
        buttonAdd = findViewById(R.id. buttonAdd)
        textView = findViewById(R.id. textView)


    }





}