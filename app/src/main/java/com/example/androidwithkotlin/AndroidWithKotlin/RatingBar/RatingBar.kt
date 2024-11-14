package com.example.androidwithkotlin.AndroidWithKotlin.RatingBar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityRatingBarBinding

class RatingBar : AppCompatActivity() {

    private lateinit var binding: ActivityRatingBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setRationBar()

    }

    private fun setRationBar() {
        binding.btnSubmit.setOnClickListener {
            val msg = binding.ratingBar.rating.toString()
            Toast.makeText(this, "Thanks for give You Feedback $msg", Toast.LENGTH_SHORT).show()
        }
    }
}