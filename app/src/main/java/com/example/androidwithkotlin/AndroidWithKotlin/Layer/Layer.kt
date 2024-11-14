package com.example.androidwithkotlin.AndroidWithKotlin.Layer

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityLayerBinding

class Layer : AppCompatActivity() {

    private lateinit var binding: ActivityLayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener() {
        binding.button.setOnClickListener {
            applyAnimation()
        }
    }

    private fun applyAnimation() {
        ValueAnimator.ofFloat(0F, 360F)
            .apply {
                addUpdateListener { animator ->
                    binding.layer.rotation = animator.animatedValue as Float
                }
                duration = 2200
                start()
            }
    }
}