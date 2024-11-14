package com.example.androidwithkotlin.AndroidWithKotlin.ViewSwitcher

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityViewSwitcherBinding

class ViewSwitcher : AppCompatActivity() {

    private lateinit var binding: ActivityViewSwitcherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewSwitcherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViewSwitcher()
    }

    private fun setupViewSwitcher() {
        val viewSwitcher = binding.viewSwitcher
        val inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        viewSwitcher.inAnimation = inAnim

        val outAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        viewSwitcher.outAnimation = outAnim

        binding.btnNext.setOnClickListener {
            viewSwitcher.showNext()
        }
    }
}