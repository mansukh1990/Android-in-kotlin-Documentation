package com.example.androidwithkotlin.ViewPager2.ViewPagerWithFragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.ViewPager2.ZoomOutPageTransformer
import com.example.androidwithkotlin.databinding.ActivityViewPagerWithFragmentBinding

@Suppress("DEPRECATION")
class ViewPagerWithFragment : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerWithFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerWithFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViewPager2()
    }

    private fun setupViewPager2() {
        val colorList = arrayListOf("#00ff00", "#ff0000", "#0000ff", "#f0f0f0", "#f0d0f0")
        binding.viewPager.adapter = ViewPagerAdapter(this, colorList)

        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val viewPage = binding.viewPager
        if (viewPage.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPage.currentItem = viewPage.currentItem - 1
        }

    }
}