package com.example.androidwithkotlin.TabLayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayout

class TabLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTabLayout()
    }

    private fun setupTabLayout() {
        val selectedPosition = binding.tabLayout.selectedTabPosition
        binding.textView.text =
            getString(R.string.selected_tab, binding.tabLayout.getTabAt(selectedPosition)?.text)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.textView.text = getString(R.string.selected_tab, tab?.text)

                val badge = tab?.orCreateBadge
                badge?.number = tab?.position!!
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                binding.textView.text = getString(R.string.selected_tab, tab?.text)

                val badge = tab?.orCreateBadge
                badge?.number = tab?.position!!

            }

        })
    }
}