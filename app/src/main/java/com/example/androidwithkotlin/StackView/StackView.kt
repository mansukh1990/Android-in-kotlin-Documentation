package com.example.androidwithkotlin.StackView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityStackViewBinding

class StackView : AppCompatActivity() {

    private lateinit var binding: ActivityStackViewBinding

    private var nameList = intArrayOf(
        R.drawable.guava,
        R.drawable.jackfruit,
        R.drawable.mix_fruit,
        R.drawable.pizza,
        R.drawable.pomegranate,
        R.drawable.strawberry,
        R.drawable.zespri_kiwi
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStackViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupStackView()

    }

    private fun setupStackView() {
        val adapter = StackAdapter(this, nameList)
        binding.stackView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}