package com.example.androidwithkotlin.AppBarLayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityAppBarLayoutBinding

class AppBarLayout : AppCompatActivity() {

    private lateinit var binding: ActivityAppBarLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBarLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)
    }
}