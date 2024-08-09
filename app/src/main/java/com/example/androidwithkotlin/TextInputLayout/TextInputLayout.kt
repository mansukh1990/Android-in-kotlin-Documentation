package com.example.androidwithkotlin.TextInputLayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityTextInputLayoutBinding

class TextInputLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTextInputLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextInputLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTextInputLayout()
    }

    private fun setupTextInputLayout() {
        binding.submit.setOnClickListener {
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()

            Toast.makeText(this, "Username : $userName , Password : $password", Toast.LENGTH_SHORT)
                .show()
        }
    }
}