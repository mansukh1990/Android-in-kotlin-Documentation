package com.example.androidwithkotlin.Chip.ChipAction

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityChipActionBinding

class ChipAction : AppCompatActivity() {

    private lateinit var binding: ActivityChipActionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChipActionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChip()

    }

    private fun setupChip() {
        binding.chip1.setOnClickListener {
            Toast.makeText(this, "Clicked on `Add Item` chip", Toast.LENGTH_SHORT).show()
        }
        binding.chip2.setOnClickListener {
            Toast.makeText(this, "Clicked on `Edit Item` chip", Toast.LENGTH_SHORT).show()
        }
        binding.chip3.setOnClickListener {
            Toast.makeText(this, "Clicked on `Delete Item` chip", Toast.LENGTH_SHORT).show()
        }

    }
}