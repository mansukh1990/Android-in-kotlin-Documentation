package com.example.androidwithkotlin.CheckedTextview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityCheckedTextviewBinding

class CheckedTextview : AppCompatActivity() {

    private lateinit var binding: ActivityCheckedTextviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckedTextviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupCheckedTextView()

    }

    private fun setupCheckedTextView() {
        val checkedTextview = binding.checkedTextView
        checkedTextview.isChecked = false
        checkedTextview.setCheckMarkDrawable(android.R.drawable.checkbox_off_background)
        checkedTextview.setText(R.string.checkedTextView)

        checkedTextview.setOnClickListener {
            checkedTextview.isChecked = !checkedTextview.isChecked
            checkedTextview.setCheckMarkDrawable(
                if (checkedTextview.isChecked) android.R.drawable.checkbox_on_background
                else android.R.drawable.checkbox_off_background
            )

            val msg = getString(R.string.pre_msg) + "" + getString(
                if (checkedTextview.isChecked) R.string.checked else R.string.unchecked
            )
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        }

    }
}