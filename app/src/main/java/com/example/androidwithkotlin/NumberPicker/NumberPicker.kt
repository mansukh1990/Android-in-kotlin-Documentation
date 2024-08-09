package com.example.androidwithkotlin.NumberPicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityNumberPickerBinding

class NumberPicker : AppCompatActivity() {

    private lateinit var binding: ActivityNumberPickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberPickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //   setupNumberPicker()

        setupNumberPickerForStringValues()
    }

    private fun setupNumberPickerForStringValues() {
        val numberPicker = binding.numberPicker
        val values = arrayOf("Blue", "Magenta", "Yellow", "Red", "Pink", "White", "Green", "Violet")
        numberPicker.minValue = 0
        numberPicker.maxValue = values.size - 1
        numberPicker.displayedValues = values
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            val text = "Changed from " + values[oldVal] + " to " + values[newVal]
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }
    }

    private fun setupNumberPicker() {
        val numberPicker = binding.numberPicker
        numberPicker.minValue = 0
        numberPicker.maxValue = 10
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            val text = "Changed from $oldVal to $newVal"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}