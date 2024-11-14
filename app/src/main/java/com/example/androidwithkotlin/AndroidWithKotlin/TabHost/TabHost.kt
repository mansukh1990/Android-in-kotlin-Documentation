package com.example.androidwithkotlin.AndroidWithKotlin.TabHost

import android.app.ActivityGroup
import android.content.Intent
import android.os.Bundle
import android.widget.TabHost
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityTabHostBinding

@Suppress("DEPRECATION")
class TabHost : ActivityGroup() {

    private lateinit var binding: ActivityTabHostBinding

    @Deprecated("Deprecated in Java")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabHostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTabHost()
    }

    private fun setupTabHost() {
        val tabHost = binding.tabHost
        tabHost.setup(this.localActivityManager)
        addTab(
            tabHost,
            getString(R.string.home),
            getString(R.string.home),
            HomeActivity::class.java
        )
        addTab(
            tabHost,
            getString(R.string.recent),
            getString(R.string.recent),
            RecentActivity::class.java
        )
        addTab(
            tabHost,
            getString(R.string.profile),
            getString(R.string.profile),
            ProfileActivity::class.java
        )
        tabHost.nextFocusUpId = 1
        tabHost.setOnTabChangedListener { tabId ->
            Toast.makeText(applicationContext, tabId, Toast.LENGTH_SHORT).show()

        }
    }

    private fun addTab(tabHost: TabHost, name: String, indicator: String, className: Class<*>) {
        val tabSpec = tabHost.newTabSpec(name)
        tabSpec.setIndicator(indicator)
        val intent = Intent(this, className)
        tabSpec.setContent(intent)
        tabHost.addTab(tabSpec)
    }
}