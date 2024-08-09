package com.example.androidwithkotlin.AppBarLayoutWithViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityAppBarLayoutWithViewPagerBinding

class AppBarLayoutWithViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityAppBarLayoutWithViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBarLayoutWithViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        setupTabLayout()
        setupViewPager()

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = ViewPagerAdapter(supportFragmentManager, binding.tabLayout.tabCount)
        }
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(this.newTab().setText(getString(R.string.gallery)))
            addTab(this.newTab().setText(getString(R.string.audio_playlist)))
            addTab(this.newTab().setText(getString(R.string.video_playlist)))
        }
    }
}