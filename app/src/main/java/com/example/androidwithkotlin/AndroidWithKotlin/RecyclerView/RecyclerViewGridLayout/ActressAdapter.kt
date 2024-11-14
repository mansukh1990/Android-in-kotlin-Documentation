package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.RecyclerViewGridLayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwithkotlin.databinding.ItemHorizontalRecyclerViewBinding

class ActressAdapter(
    private val actressList: ArrayList<Actress>,
    private val listener: (Actress, Int) -> Unit
) : RecyclerView.Adapter<ActressAdapter.ViewHolder>() {

    class ViewHolder(var itemBinding: ItemHorizontalRecyclerViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(actress: Actress) {
            itemBinding.name.text = actress.name
            itemBinding.image.setImageResource(actress.image)
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
        return actressList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(actressList[position])
        holder.itemView.setOnClickListener {
            listener(actressList[position], position)
        }
    }
}