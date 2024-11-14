package com.example.androidwithkotlin.AndroidWithKotlin.ViewPager2.ViewPagerWithFragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.FragmentItemBinding

class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.label.text = getString(R.string.app_name)

        val color = arguments?.getString("color")
        binding.root.setBackgroundColor(Color.parseColor(color))

        val position = arguments?.getString("label")
        binding.label.text = position

    }
}