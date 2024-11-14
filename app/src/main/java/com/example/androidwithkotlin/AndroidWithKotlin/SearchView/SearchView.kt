package com.example.androidwithkotlin.AndroidWithKotlin.SearchView

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivitySearchViewBinding

class SearchView : AppCompatActivity() {

    private lateinit var binding: ActivitySearchViewBinding
    private lateinit var adapter: ArrayAdapter<String>

    var cityList = listOf(
        "America",
        "India",
        "Nepal",
        "China",
        "Sri Lanka",
        "South Africa",
        "Bangladesh",
        "England",
        "Bhutan",
        "Finland",
        "Greenland"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupListView()
        setupSearchView()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val isMathchFound = cityList.contains(query)
                val msg = if (isMathchFound) "Found: $query" else getString(R.string.no_match)
                Toast.makeText(this@SearchView, msg, Toast.LENGTH_SHORT).show()
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun setupListView() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityList)
        binding.listView.adapter = adapter
    }
}