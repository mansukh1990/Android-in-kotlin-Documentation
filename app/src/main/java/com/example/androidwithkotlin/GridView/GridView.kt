package com.example.androidwithkotlin.GridView

import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityGridViewBinding

class GridView : AppCompatActivity() {

    private lateinit var binding: ActivityGridViewBinding

    private val itemList: Array<String>
        get() = arrayOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
            "Item 11",
            "Item 12",
            "Item 13",
            "Item 14",
            "Item 15",
            "Item 16",
            "Item 17",
            "Item 18",
            "Item 19",
            "Item 20",
            "Item 21",
            "Item 22"

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupGridView()

    }

    private fun setupGridView() {
        val adapter = ImageListAdapter(this, R.layout.list_item_grid_view, itemList)
        binding.gridView.adapter = adapter

        binding.gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Clicked Position: " + (position + 1), Toast.LENGTH_SHORT)
                    .show()
            }
    }
}