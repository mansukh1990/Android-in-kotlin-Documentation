package com.example.androidwithkotlin.AndroidWithKotlin.ViewPager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.androidwithkotlin.databinding.ActivityViewPagerTwoBinding

@Suppress("DEPRECATION")
class ViewPagerTwo : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerTwoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViewPager2()
    }

    private fun setupViewPager2() {
        val list: MutableList<String> = ArrayList()
        list.add("This is your first screen")
        list.add("This is your second screen")
        list.add("This is your third screen")
        list.add("This is Fourth screen")

        val colorList: MutableList<String> = ArrayList()
        colorList.add("#00ff00")
        colorList.add("#ff0000")
        colorList.add("#0000ff")
        colorList.add("#f0f0f0")

        binding.viewPager.adapter = ViewPagerAdapter(this, list, colorList)
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())

        setupPageChangeCallback()

    }

    private fun setupPageChangeCallback() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
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