package com.example.androidwithkotlin.AndroidWithKotlin.SeekBar

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivitySeekBarBinding

class SeekBar : AppCompatActivity() {

    private lateinit var binding: ActivitySeekBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.text = "Progress:${binding.seekBar.progress}"

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView.text = "Progress: $progress"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                binding.textView.text = "Progress is ${binding.seekBar.progress}" + "%"
            }

        })

    }
}