package com.example.androidwithkotlin.AndroidWithKotlin.Barrier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityBarrierBinding

class Barrier : AppCompatActivity() {
    private lateinit var binding: ActivityBarrierBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarrierBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}