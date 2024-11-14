package com.example.androidwithkotlin.AndroidWithKotlin.TextClock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityTextClockBinding

class TextClock : AppCompatActivity() {

    private lateinit var binding: ActivityTextClockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextClockBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}