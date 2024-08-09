package com.example.androidwithkotlin.ChronoMeter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityChronoMeterBinding

class ChronoMeter : AppCompatActivity() {

    private lateinit var binding: ActivityChronoMeterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChronoMeterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupChronoMeter()


    }

    private fun setupChronoMeter() {
        binding.btnStart.setOnClickListener(object : View.OnClickListener {

            var isPlaying = false

            override fun onClick(v: View?) {
                val chronoMeter = binding.chronometer
                isPlaying = if (!isPlaying) {
                    chronoMeter.start()
                    true
                } else {
                    chronoMeter.stop()
                    false
                }

                binding.btnStart.setText(if (isPlaying) R.string.stop else R.string.start)
                Toast.makeText(this@ChronoMeter, getString(if (isPlaying) R.string.playing else R.string.stopped), Toast.LENGTH_SHORT).show()

            }

        })
    }
}