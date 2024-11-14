package com.example.androidwithkotlin.AndroidWithKotlin.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val COUNT = 3

    override fun getCount(): Int {
        return COUNT

    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }

            1 -> {
                SecondFragment()
            }

            2 -> {
                ThirdFragment()
            }

            else -> FirstFragment()
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        //   return "Tab" + (position + 1)
        return when (position) {
            0 -> {
                "FirstFragment"
            }

            1 -> {
                "SecondFragment"
            }

            2 -> {
                "ThirdFragment"
            }

            else -> {
                "ThirdFragment"
            }
        }

    }
}