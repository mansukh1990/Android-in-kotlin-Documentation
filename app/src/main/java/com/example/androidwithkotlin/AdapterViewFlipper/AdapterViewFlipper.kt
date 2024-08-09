package com.example.androidwithkotlin.AdapterViewFlipper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityAdapterViewFlipperBinding

class AdapterViewFlipper : AppCompatActivity() {

    private lateinit var binding: ActivityAdapterViewFlipperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdapterViewFlipperBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupAdapterViewFlipper()

    }

    private fun setupAdapterViewFlipper() {
        val adapterViewFlipper = binding.adapterViewFlipper
        adapterViewFlipper.setInAnimation(this, R.animator.left_in)
        adapterViewFlipper.setInAnimation(this, R.animator.right_out)

        val nameList = arrayOf(
            "Guava",
            "JackFruit",
            "Mix Fruit",
            "Apple",
            "Pomegranate",
            "Strawberry",
            "Zespri Kiwi"
        )
        val imageList = intArrayOf(
            R.drawable.guava,
            R.drawable.jackfruit,
            R.drawable.mix_fruit,
            R.drawable.pizza,
            R.drawable.pomegranate,
            R.drawable.strawberry,
            R.drawable.zespri_kiwi
        )
        val adapter = CustomAdapter(this, nameList, imageList)
        adapterViewFlipper.adapter = adapter
    }
}