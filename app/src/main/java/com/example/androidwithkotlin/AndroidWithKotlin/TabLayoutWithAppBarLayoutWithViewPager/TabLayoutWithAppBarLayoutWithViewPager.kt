package com.example.androidwithkotlin.AndroidWithKotlin.TabLayoutWithAppBarLayoutWithViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityTabLayoutWithAppBarLayoutWithViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

@Suppress("DEPRECATION")
class TabLayoutWithAppBarLayoutWithViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutWithAppBarLayoutWithViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutWithAppBarLayoutWithViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)
        setupViewPager()
        setupTabLayout()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "Tab " + (position + 1)
        }.attach()
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this, 2)
        binding.viewPager.adapter = adapter
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val viewPager = binding.viewPager
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }

    }
}