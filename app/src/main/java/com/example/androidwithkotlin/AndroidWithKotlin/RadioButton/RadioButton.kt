package com.example.androidwithkotlin.AndroidWithKotlin.RadioButton

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityRadioButtonBinding

class RadioButton : AppCompatActivity() {

    private lateinit var binding: ActivityRadioButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setCheckedChangedListener()
    }

    private fun setCheckedChangedListener() {
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val text = "You Selected: " + if (R.id.radioMale == checkedId) "male" else "female"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}