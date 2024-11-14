package com.example.androidwithkotlin.AndroidWithKotlin.MultiAutoCompleteTextview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityMultiAutoCompleteTextviewBinding

class MultiAutoCompleteTextview : AppCompatActivity() {

    private lateinit var binding: ActivityMultiAutoCompleteTextviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMultiAutoCompleteTextviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupMultiAutoCompleteTextview()
    }

    private fun setupMultiAutoCompleteTextview() {
        val countries = resources.getStringArray(R.array.countries_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        binding.multiAutoCompleteTextView.setAdapter(adapter)

        binding.multiAutoCompleteTextView.threshold = 1
        binding.multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        binding.btnSubmit.setOnClickListener {
            val text = "Enter text:" + "" + binding.multiAutoCompleteTextView.text
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }
    }
}