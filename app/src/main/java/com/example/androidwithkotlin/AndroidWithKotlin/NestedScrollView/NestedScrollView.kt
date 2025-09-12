package com.example.androidwithkotlin.AndroidWithKotlin.NestedScrollView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityNestedScrollViewBinding

class NestedScrollView : AppCompatActivity() {

    private lateinit var binding: ActivityNestedScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNestedScrollViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}