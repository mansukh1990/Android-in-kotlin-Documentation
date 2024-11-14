package com.example.androidwithkotlin.AndroidWithKotlin.ImageFilterButton

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityImageFilterButtonBinding

class ImageFilterButton : AppCompatActivity() {

    private lateinit var binding: ActivityImageFilterButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageFilterButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCrossFadeSeekBar()
    }

    private fun setupCrossFadeSeekBar() {
        binding.crossFadeSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val percentage = (progress / 100.0f)
                binding.imageFilterButton.crossfade = (percentage)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}