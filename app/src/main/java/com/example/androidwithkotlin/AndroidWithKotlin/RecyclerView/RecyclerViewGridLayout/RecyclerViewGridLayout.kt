package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.RecyclerViewGridLayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityRecyclerViewGridLayoutBinding

class RecyclerViewGridLayout : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewGridLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewGridLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ActressAdapter(createActressList()) { actress, position ->
                Toast.makeText(
                    this@RecyclerViewGridLayout,
                    "Clicked on actress:${actress.name}",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    private fun createActressList(): ArrayList<Actress> {
        return arrayListOf<Actress>(
            Actress(
                "Amber Heard",
                R.drawable.amber_heard
            ),
            Actress(
                "Ananya pandey",
                R.drawable.ananya_panday
            ),
            Actress(
                "Anushka Shetty",
                R.drawable.anushka_shetty
            ),
            Actress(
                "Disha Patani",
                R.drawable.disha_patani
            ),
            Actress(
                "Drew Barrymore",
                R.drawable.drew_barrymore
            ),
            Actress(
                "Kristen Stewart",
                R.drawable.kristen_stewart
            ),
            Actress(
                "Kriti Sanon",
                R.drawable.kriti_sanon
            ),
            Actress(
                "Mishti",
                R.drawable.mishti
            ),
            Actress(
                "Nicole",
                R.drawable.nicole
            ),
            Actress(
                "Priyanka Chopra",
                R.drawable.priyanka_chopra
            ),
            Actress(
                "Rashami Desai",
                R.drawable.rashami_desai
            ),
            Actress(
                "Tamanna",
                R.drawable.tamanna
            )
        )

    }
}