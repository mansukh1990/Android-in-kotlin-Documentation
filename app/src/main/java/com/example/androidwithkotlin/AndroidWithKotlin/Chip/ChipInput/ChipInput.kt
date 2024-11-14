package com.example.androidwithkotlin.AndroidWithKotlin.Chip.ChipInput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityChipInputBinding

class ChipInput : AppCompatActivity() {

    private lateinit var binding: ActivityChipInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChipInputBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}