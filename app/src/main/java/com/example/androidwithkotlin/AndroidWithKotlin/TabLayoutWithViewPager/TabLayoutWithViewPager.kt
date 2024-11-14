package com.example.androidwithkotlin.AndroidWithKotlin.TabLayoutWithViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityTabLayoutWithViewPagerBinding
import com.google.android.material.tabs.TabLayout

class TabLayoutWithViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutWithViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutWithViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTabLayout()
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = ViewPagerAdapter(supportFragmentManager, binding.tabLayout.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        }
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(this.newTab().setText("Tab 1"))
            addTab(this.newTab().setText("Tab 2"))
            addTab(this.newTab().setText("Tab 3"))

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.position?.let {
                        binding.viewPager.currentItem = it

                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
        }
    }
}