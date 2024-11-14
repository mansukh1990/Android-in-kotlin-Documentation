package com.example.androidwithkotlin.AndroidWithKotlin.ImageFilterView

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityImageFilterViewBinding

class ImageFilterView : AppCompatActivity() {

    private lateinit var binding: ActivityImageFilterViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageFilterViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSaturationSeekbar()
        setupContrastSeekbar()
        setupWarmthSeekbar()

    }

    private fun setupWarmthSeekbar() {
        binding.warmthSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val percentage = (progress / 100.0f)
                binding.imageFilterView.warmth = (percentage + 1)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun setupContrastSeekbar() {
        binding.contrastSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val percentage = (progress / 100.0f)
                binding.imageFilterView.contrast = (percentage + 1)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun setupSaturationSeekbar() {
        binding.saturationSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val percentage = (progress / 100.0f)
                binding.imageFilterView.saturation = (percentage + 1)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}