package com.example.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Tabactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var viewPager = findViewById<ViewPager>(R.id.viewpager)
        var tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(Tab1(),"Tab 1")
        fragmentAdapter.addFragment(Tab2(),"Tab 2")
        fragmentAdapter.addFragment(Tab3(),"Tab 3")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)


    }
}