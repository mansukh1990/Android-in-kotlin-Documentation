package com.example.androidwithkotlin.Space

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivitySpaceBinding

class Space : AppCompatActivity() {

    private lateinit var binding: ActivitySpaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpaceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}