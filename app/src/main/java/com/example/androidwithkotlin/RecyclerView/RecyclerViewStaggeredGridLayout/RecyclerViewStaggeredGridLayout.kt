package com.example.androidwithkotlin.RecyclerView.RecyclerViewStaggeredGridLayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityRecyclerViewStaggeredGridLayoutBinding

class RecyclerViewStaggeredGridLayout : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewStaggeredGridLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewStaggeredGridLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = FlowerAdapter(createFlowerList()) { flower, _ ->
                Toast.makeText(
                    this@RecyclerViewStaggeredGridLayout,
                    "Clicked on flower :${flower.name}",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    private fun createFlowerList(): ArrayList<Flower> {
        return arrayListOf<Flower>(
            Flower(
                "Blue Bell",
                R.drawable.bluebell
            ),
            Flower(
                "Calendula",
                R.drawable.calendula
            ),
            Flower(
                "Iris",
                R.drawable.iris
            ),
            Flower(
                "Jasmine",
                R.drawable.jasmine
            ),
            Flower(
                "Lavender",
                R.drawable.lavender
            ),
            Flower(
                "Lily",
                R.drawable.lily
            ),
            Flower(
                "Lotus",
                R.drawable.lotus
            ),
            Flower(
                "MaryGold",
                R.drawable.marygold
            ),
            Flower(
                "Orchid",
                R.drawable.orchid
            ),
            Flower(
                "Poppy",
                R.drawable.poppy
            ),
            Flower(
                "Rose",
                R.drawable.rose
            ),
            Flower(
                "Rosemary Dahlia",
                R.drawable.rosemary_dahlia
            ),
            Flower(
                "Sunflower",
                R.drawable.sunflower
            ),
            Flower(
                "Tulip",
                R.drawable.tulip
            )
        )
    }
}