package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.RecyclerViewStaggeredGridLayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwithkotlin.databinding.FlowerItemBinding

class FlowerAdapter(
    private val flowerList: ArrayList<Flower>,
    private val listener: (Flower, Int) -> Unit
) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    class ViewHolder(var itemBinding: FlowerItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(flower: Flower) {
            itemBinding.name.text = flower.name
            itemBinding.image.setImageResource(flower.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = FlowerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(flowerList[position])
        holder.itemView.setOnClickListener {
            listener(flowerList[position], position)
        }
    }
}