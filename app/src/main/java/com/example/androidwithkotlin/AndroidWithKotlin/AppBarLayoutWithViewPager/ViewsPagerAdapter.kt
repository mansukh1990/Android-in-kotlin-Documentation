@file:Suppress("DEPRECATION")

package com.example.androidwithkotlin.AndroidWithKotlin.AppBarLayoutWithViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewsPagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> GalleryFragment()
            1 -> AudioFragment()
            2 -> VideoFragment()
            else -> GalleryFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Tab " + (position + 1)
    }
}