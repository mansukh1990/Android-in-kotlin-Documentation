package com.example.androidwithkotlin.ViewFlipper

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityViewFlipperBinding

class ViewFlipper : AppCompatActivity() {

    private lateinit var binding: ActivityViewFlipperBinding
    private var imageList = intArrayOf(
        R.drawable.guava,
        R.drawable.jackfruit,
        R.drawable.mix_fruit,
        R.drawable.pomegranate,
        R.drawable.strawberry,
        R.drawable.zespri_kiwi
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewFlipperBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViewFlipper()

    }

    private fun setupViewFlipper() {
        val viewFlipper = binding.viewFlipper
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
        viewFlipper.setInAnimation(this, android.R.anim.slide_out_right)

        for (image in imageList) {
            val imageView = ImageView(this)
            val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(30, 30, 30, 30)
            layoutParams.gravity = Gravity.CENTER
            imageView.setImageResource(image)
            viewFlipper.addView(imageView)
        }

        binding.playPause.setOnClickListener {
            if (viewFlipper.isFlipping)
                viewFlipper.stopFlipping()
            else
                viewFlipper.startFlipping()

            binding.playPause.text =
                getString(if (viewFlipper.isFlipping) R.string.pause else R.string.play)
            Toast.makeText(
                this,
                getString(if (viewFlipper.isFlipping) R.string.flipping_started else R.string.flipping_stopped),
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}