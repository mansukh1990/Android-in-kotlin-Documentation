package com.example.androidwithkotlin.AndroidWithKotlin.TextSwitcher

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityTextSwitcherBinding

class TextSwitcher : AppCompatActivity() {

    private lateinit var binding: ActivityTextSwitcherBinding

    private var textList = arrayOf(
        "Panda", "Tiger", "Zebra", "Lion", "Deer", "Goat", "Ape", "Monkey", "Human"
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextSwitcherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTextSwitcher()

    }

    private fun setupTextSwitcher() {
        binding.textSwitcher.setFactory {
            val textView = TextView(this)
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.RED)
            textView
        }
        binding.textSwitcher.setText(textList[index])

        val inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        binding.textSwitcher.inAnimation = inAnim

        val out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        binding.textSwitcher.outAnimation = out

        binding.btnNext.setOnClickListener {
            index = if (index + 1 < textList.size) index + 1 else 0
            binding.textSwitcher.setText(textList[index])
        }
    }
}