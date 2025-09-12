package com.example.androidwithkotlin.AndroidWithKotlin.DiscreteSeekBar

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityDiscreteSeekBarBinding

class DiscreteSeekBar : AppCompatActivity() {

    private lateinit var binding: ActivityDiscreteSeekBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiscreteSeekBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupDecreteSeekBar()

        binding.textView.text = "Pogress : ${binding.discreteSeekBar.progress}"
    }

    private fun setupDecreteSeekBar() {
        binding.discreteSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView.text = "Progress: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    binding.textView.setText("Current Value is " + seekBar.progress)
                }
            }

        })
    }
}