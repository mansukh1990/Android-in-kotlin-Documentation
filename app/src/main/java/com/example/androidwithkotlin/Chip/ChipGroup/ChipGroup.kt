package com.example.androidwithkotlin.Chip.ChipGroup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityChipGroupBinding

class ChipGroup : AppCompatActivity() {

    private lateinit var binding: ActivityChipGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChipGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChipGroup()
    }

    private fun setupChipGroup() {
        binding.chip1.setOnCloseIconClickListener {
            binding.chipGroup.removeView(it)
            Toast
                .makeText(this, "Removed 1st Chip", Toast.LENGTH_SHORT)
                .show()
        }

        binding.chip2.setOnCloseIconClickListener {
            binding.chipGroup.removeView(it)
            Toast
                .makeText(this, "Removed 2nd Chip", Toast.LENGTH_SHORT)
                .show()
        }
        binding.chip3.setOnCloseIconClickListener {
            binding.chipGroup.removeView(it)
            Toast
                .makeText(this, "Removed 3rd Chip", Toast.LENGTH_SHORT)
                .show()
        }
        binding.chip4.setOnCloseIconClickListener {
            binding.chipGroup.removeView(it)
            Toast
                .makeText(this, "Removed 4th Chip", Toast.LENGTH_SHORT)
                .show()
        }
        binding.chip5.setOnCloseIconClickListener {
            binding.chipGroup2.removeView(it)
            Toast
                .makeText(this, "Removed 5th Chip", Toast.LENGTH_SHORT)
                .show()
        }
        binding.chip6.setOnCloseIconClickListener {
            binding.chipGroup2.removeView(it)
            Toast
                .makeText(this, "Removed 6th Chip", Toast.LENGTH_SHORT)
                .show()
        }
        binding.chip7.setOnCloseIconClickListener {
            binding.chipGroup2.removeView(it)
            Toast
                .makeText(this, "Removed 7th Chip", Toast.LENGTH_SHORT)
                .show()
        }
        binding.chip8.setOnCloseIconClickListener {
            binding.chipGroup2.removeView(it)
            Toast
                .makeText(this, "Removed 8th Chip", Toast.LENGTH_SHORT)
                .show()
        }

    }
}