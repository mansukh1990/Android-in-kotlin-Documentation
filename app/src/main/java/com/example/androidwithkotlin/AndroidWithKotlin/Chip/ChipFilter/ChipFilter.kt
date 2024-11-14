package com.example.androidwithkotlin.AndroidWithKotlin.Chip.ChipFilter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityChipFilterBinding

class ChipFilter : AppCompatActivity() {

    private lateinit var binding: ActivityChipFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChipFilterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}