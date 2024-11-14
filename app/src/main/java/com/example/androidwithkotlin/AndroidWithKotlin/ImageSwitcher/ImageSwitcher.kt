package com.example.androidwithkotlin.AndroidWithKotlin.ImageSwitcher

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityImageSwitcherBinding

class ImageSwitcher : AppCompatActivity() {

    private lateinit var binding: ActivityImageSwitcherBinding

    private var nameList = intArrayOf(
        R.drawable.chinchilla,
        R.drawable.cod,
        R.drawable.crane,
        R.drawable.crocodile,
        R.drawable.deer,
        R.drawable.dog,
        R.drawable.dolphin,
        R.drawable.dove,
        R.drawable.eel,
        R.drawable.elephant,
        R.drawable.emu,
        R.drawable.fly
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSwitcherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupImageSwitcher()
    }

    private fun setupImageSwitcher() {
        binding.imageSwitcher.setFactory {
            val imageView = android.widget.ImageView(applicationContext)
            imageView.scaleType = android.widget.ImageView.ScaleType.FIT_CENTER
            imageView.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
            imageView
        }
        binding.imageSwitcher.setImageResource(nameList[index])

        val inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        binding.imageSwitcher.inAnimation = inAnim

        val out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        binding.imageSwitcher.outAnimation = out

        binding.btnNext.setOnClickListener {
            index = if (++index < nameList.size) index else 0
            binding.imageSwitcher.setImageResource(nameList[index])
        }
    }
}