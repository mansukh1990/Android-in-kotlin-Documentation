package com.example.androidwithkotlin.AndroidWithKotlin.ViewAnimator

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.databinding.ActivityViewAnimatorBinding

class ViewAnimator : AppCompatActivity() {

    private lateinit var binding: ActivityViewAnimatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAnimatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViewAnimator()


    }

    private fun setupViewAnimator() {
        val inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        val outAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        binding.viewAnimator.inAnimation = inAnim
        binding.viewAnimator.inAnimation = outAnim


        binding.buttonNext.setOnClickListener {
            binding.viewAnimator.showNext()

        }
        binding.buttonPrev.setOnClickListener {
            binding.viewAnimator.showPrevious()
        }
    }
}