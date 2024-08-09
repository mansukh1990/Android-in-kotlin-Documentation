package com.example.androidwithkotlin.Guideline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityGuidelineBinding

class Guideline : AppCompatActivity() {

    private lateinit var binding: ActivityGuidelineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuidelineBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}