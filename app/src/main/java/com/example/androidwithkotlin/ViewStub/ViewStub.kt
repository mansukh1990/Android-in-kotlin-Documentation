package com.example.androidwithkotlin.ViewStub

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityViewStubBinding

class ViewStub : AppCompatActivity() {

    private lateinit var binding: ActivityViewStubBinding
    private var isViewInflated = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewStubBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViewStub()

    }

    private fun setupViewStub() {
        binding.viewStub.visibility = View.VISIBLE

        binding.btnHide.setOnClickListener {
            isViewInflated = !isViewInflated
            binding.viewStub.visibility = if (isViewInflated) View.VISIBLE else View.GONE
            binding.btnHide.text =
                getString(if (isViewInflated) R.string.hide else R.string.show)
        }
    }
}