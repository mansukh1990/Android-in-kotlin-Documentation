package com.example.androidwithkotlin.AutoCompleteTextview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityAutoCompleteTextviewBinding

class AutoCompleteTextview : AppCompatActivity() {

    private lateinit var binding: ActivityAutoCompleteTextviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAutoCompleteTextviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupAutoCompleteTextView()
    }

    private fun setupAutoCompleteTextView() {
        val countries = resources.getStringArray(R.array.countries_array)
        val adapter =
            ArrayAdapter(this@AutoCompleteTextview, android.R.layout.simple_list_item_1, countries)
        binding.autoCompleteTextview.setAdapter(adapter)

        binding.btnSubmit.setOnClickListener {
            val text = getString(R.string.entered_text) + " " + binding.autoCompleteTextview.text
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

    }
}