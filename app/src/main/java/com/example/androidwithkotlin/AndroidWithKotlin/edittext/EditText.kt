package com.example.androidwithkotlin.AndroidWithKotlin.edittext

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityEditTextBinding

class EditText : AppCompatActivity() {
    private lateinit var binding: ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEditText()

    }

    private fun addEditText() {

        val padding = resources.getDimension(R.dimen.text_padding).toInt()
        val editText = EditText(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(padding, padding, padding, padding)
        editText.layoutParams = layoutParams
        editText.setText("Enter here something...")
        editText.gravity = Gravity.START
        editText.id = R.id.editTextId
        binding.main.addView(editText)
    }
}