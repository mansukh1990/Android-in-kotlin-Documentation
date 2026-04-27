package com.example.androidwithkotlin.AndroidWithKotlin.TimePicker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityTimePickerBinding

class TimePicker : AppCompatActivity() {

    private lateinit var binding: ActivityTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTimePicker()
    }

    private fun setupTimePicker() {
        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val dayHour = when {
                hourOfDay == 0 -> {
                    0 + 12
                }

                hourOfDay > 12 -> {
                    hourOfDay - 12
                }

                else -> hourOfDay
            }
            val format = when {
                hourOfDay >= 12 -> {
                    "PM"
                }

                else -> "AM"
            }
            val hour = if (dayHour < 10) "0$dayHour" else dayHour
            val min = if (minute < 10) "0$minute" else minute

            val text = getString(R.string.selected_time) + " " + hour + " : " + min + " " + format
            binding.textView.text = text
            binding.textView.visibility = View.VISIBLE
        }
    }
}