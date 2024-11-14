package com.example.androidwithkotlin.AndroidWithKotlin.FloatingActionButton

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButton : AppCompatActivity() {

    private lateinit var binding: ActivityFloatingActionButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFloatingActionButtonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupFloatingActionButton()
    }

    private fun setupFloatingActionButton() {
        binding.fab.setOnClickListener {
            Toast.makeText(this, "You clicked Floating Action Button", Toast.LENGTH_SHORT).show()
        }
    }
}