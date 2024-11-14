package com.example.androidwithkotlin.AndroidWithKotlin.DatePicker

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityDatePickerBinding
import java.util.Calendar

class DatePicker : AppCompatActivity() {

    private lateinit var binding: ActivityDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupDatePicker()
    }

    private fun setupDatePicker() {
        val today = Calendar.getInstance()
        binding.datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
        ) { _, year, monthOfYear, dayOfMonth ->
            val month = monthOfYear + 1
            val msg = "Selected Date is $dayOfMonth/$month/$year"

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

            binding.textView.text = msg
            binding.textView.visibility = View.VISIBLE
        }
    }
}