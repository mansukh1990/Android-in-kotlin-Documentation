package com.example.androidwithkotlin.AndroidWithKotlin.CardView

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityCardViewBinding

class CardView : AppCompatActivity() {

    private lateinit var binding: ActivityCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupCardView()
    }

    private fun setupCardView() {
        binding.cardView1.setOnClickListener {
            Toast.makeText(this, "Clicked on card 1", Toast.LENGTH_SHORT).show()
        }
    }
}