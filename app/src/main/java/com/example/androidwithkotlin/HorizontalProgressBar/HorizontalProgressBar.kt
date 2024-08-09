package com.example.androidwithkotlin.HorizontalProgressBar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityHorizontalProgressBarBinding

class HorizontalProgressBar : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalProgressBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalProgressBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupProgressBar()
    }

    private fun setupProgressBar() {
        val progressBar = binding.progressbarId
        binding.buttonId.setOnClickListener {
            val visibility = if (progressBar.visibility == View.GONE) View.VISIBLE else View.GONE
            progressBar.visibility = visibility

            val btnText =
                if (progressBar.visibility == View.GONE) "SHOW PROGRESSBAR" else "HIDE PROGRESSBAR"
            binding.buttonId.text = btnText
        }
    }
}