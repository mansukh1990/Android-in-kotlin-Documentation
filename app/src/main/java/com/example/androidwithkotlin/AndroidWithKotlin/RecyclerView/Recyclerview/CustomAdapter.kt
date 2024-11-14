package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.Recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwithkotlin.databinding.ListItemRecyclerviewBinding

class CustomAdapter(
    private val animalList: ArrayList<Animal>,
    private val listener: (Animal, Int) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ListItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(animalList[position])
        holder.itemView.setOnClickListener {
            listener(animalList[position], position)
        }
    }

    class ViewHolder(val listItemRecyclerviewBinding: ListItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(listItemRecyclerviewBinding.root) {
        fun bindItem(animal: Animal) {
            listItemRecyclerviewBinding.image.setImageResource(animal.image)
            listItemRecyclerviewBinding.name.text = animal.name
            listItemRecyclerviewBinding.description.text = animal.deatials
        }

    }
}