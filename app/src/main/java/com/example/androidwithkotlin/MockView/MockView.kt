package com.example.androidwithkotlin.MockView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityMockViewBinding

class MockView : AppCompatActivity() {

    private lateinit var binding: ActivityMockViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMockViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}