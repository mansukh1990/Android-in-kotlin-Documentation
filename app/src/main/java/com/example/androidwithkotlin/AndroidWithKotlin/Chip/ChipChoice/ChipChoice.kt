package com.example.androidwithkotlin.AndroidWithKotlin.Chip.ChipChoice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityChipChoiceBinding

class ChipChoice : AppCompatActivity() {

    private lateinit var binding: ActivityChipChoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChipChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}