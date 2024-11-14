package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.RecyclerViewHorizontal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwithkotlin.databinding.ItemHorizontalRecyclerViewBinding

class CustomAdapter(
    private val heroList: ArrayList<Hero>,
    private val listener: (Hero, Int) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(var itemBinding: ItemHorizontalRecyclerViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(hero: Hero) {
            itemBinding.image.setImageResource(hero.image)
            itemBinding.name.text = hero.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHorizontalRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(heroList[position])
        holder.itemView.setOnClickListener {
            listener(heroList[position], position)
        }
    }
}