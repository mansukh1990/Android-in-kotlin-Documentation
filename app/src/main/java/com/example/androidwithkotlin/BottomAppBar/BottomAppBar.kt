package com.example.androidwithkotlin.BottomAppBar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityBottomAppBarBinding

class BottomAppBar : AppCompatActivity() {

    private lateinit var binding: ActivityBottomAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomAppBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.fab.setOnClickListener {
            Toast.makeText(this, "FAB Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Serach Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.photos -> {
                    Toast.makeText(this, "Photos Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.option_1 -> {
                    Toast.makeText(this, "Option 1 Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }
}