package com.example.androidwithkotlin.ImageView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityImageViewBinding

class ImageView : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupImageView()

    }

    private fun setupImageView() {
        val imageResId = R.drawable.ic_launcher_background
        var resId = imageResId

        binding.imageView.setImageResource(resId)

        binding.btnChangeImage.setOnClickListener {
            resId = if (resId == R.drawable.ic_launcher_background)
                R.mipmap.ic_launcher
            else
                R.drawable.ic_launcher_background
            binding.imageView.setImageResource(resId)
        }
    }
}