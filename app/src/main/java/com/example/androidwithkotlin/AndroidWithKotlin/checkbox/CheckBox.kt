package com.example.androidwithkotlin.AndroidWithKotlin.checkbox

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityCheckBoxBinding

class CheckBox : AppCompatActivity() {

    private lateinit var binding: ActivityCheckBoxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setCheckedChangedListener()
    }

    private fun setCheckedChangedListener() {
        binding.checkboxId.setOnCheckedChangeListener { _, isChecked ->
            val msg = "you have" + if (isChecked) " checked" else " unchecked"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        }
    }
}