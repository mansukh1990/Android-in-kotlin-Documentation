package com.example.androidwithkotlin.CardView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityCardViewSecondBinding

class CardViewSecond : AppCompatActivity() {

    private lateinit var binding: ActivityCardViewSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewSecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}