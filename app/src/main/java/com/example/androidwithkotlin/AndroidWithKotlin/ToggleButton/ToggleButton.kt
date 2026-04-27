package com.example.androidwithkotlin.AndroidWithKotlin.ToggleButton

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.TogglebttonBinding

class ToggleButton : AppCompatActivity() {

    private lateinit var binding: TogglebttonBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TogglebttonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setCheckedChangedListener()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setCheckedChangedListener() {
        binding.toggleButtonId.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.toggleButtonId.setBackgroundColor(getColor(R.color.green))
                Toast.makeText(this, "Toggle Button is ON", Toast.LENGTH_SHORT).show()
            } else {
                binding.toggleButtonId.setBackgroundColor(getColor(R.color.red))
                Toast.makeText(this, "Toggle Button is OFF", Toast.LENGTH_SHORT).show()
            }

        }
    }
}