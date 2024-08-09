package com.example.androidwithkotlin.HorizontalDivider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityHorizontalDividerBinding

class HorizontalDivider : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalDividerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalDividerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}