package com.example.androidwithkotlin.AndroidWithKotlin.BottomNavigationView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityBottomNavigationViewBinding

class BottomNavigationView : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()
        loadFragment(HomeFragment())
    }

    private fun setupClickListener() {
        binding.bottomNavigationView.setOnItemSelectedListener {

            val fragment = when (it.itemId) {
                R.id.wishlist -> {
                    WishlistFragment()
                }

                R.id.profile -> {
                    ProfileFragment()
                }

                else -> {
                    HomeFragment()
                }
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}