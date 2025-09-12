package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.RecyclerViewHorizontal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityRecyclerViewHorizontalBinding

class RecyclerViewHorizontal : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewHorizontalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewHorizontalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = CustomAdapter(createHeroList()) { hero, _ ->
                Toast.makeText(
                    this@RecyclerViewHorizontal,
                    "Clicked on actor: ${hero.name}",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    private fun createHeroList(): ArrayList<Hero> {
        return arrayListOf<Hero>(
            Hero("Ajay Devgan", R.drawable.ajay),
            Hero("Chris Hemsworth", R.drawable.chris_hemsworth),
            Hero("Daniel Craig", R.drawable.daniel_craig),
            Hero("Dwayne Johnson", R.drawable.dwayne_johnson),
            Hero("Tom Hiddlestone", R.drawable.tom_hiddleston),
            Hero("Tony Stark", R.drawable.tony_stark),
            Hero("Ajay Devgan", R.drawable.ajay),
            Hero("Chris Hemsworth", R.drawable.chris_hemsworth),
            Hero("Daniel Craig", R.drawable.daniel_craig),
            Hero("Dwayne Johnson", R.drawable.dwayne_johnson),
            Hero("Tom Hiddlestone", R.drawable.tom_hiddleston),
            Hero("Tony Stark", R.drawable.tony_stark),
            Hero("Ajay Devgan", R.drawable.ajay),
            Hero("Chris Hemsworth", R.drawable.chris_hemsworth),
            Hero("Daniel Craig", R.drawable.daniel_craig),
            Hero("Dwayne Johnson", R.drawable.dwayne_johnson),
            Hero("Tom Hiddlestone", R.drawable.tom_hiddleston),
            Hero("Tony Stark", R.drawable.tony_stark)
        )

    }


}