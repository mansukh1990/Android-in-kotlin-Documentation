package com.example.androidwithkotlin.AndroidWithKotlin.Group

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityGroupBinding

class Group : AppCompatActivity() {

    private lateinit var binding: ActivityGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupGroup()

    }

    private fun setupGroup() {
        binding.btnShow.setOnClickListener {
            binding.group.visibility = View.VISIBLE
        }
        binding.btnHide.setOnClickListener {
            binding.group.visibility = View.INVISIBLE
        }
    }
}