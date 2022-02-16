package com.flurry.android.sample.eventfeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.flurry.android.FlurryAgent
import com.flurry.android.FlurryPerformance
import com.flurry.android.sample.eventfeatures.viewpager.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var pageTitle = listOf("Advertisement","Privacy","Registration","Social")
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.main_pager)
        viewPager.adapter = FragmentAdapter(supportFragmentManager,lifecycle,pageTitle.size)
        tabLayout = findViewById(R.id.main_tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = pageTitle[position]
        }.attach()

    }
}