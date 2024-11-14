package com.example.androidwithkotlin.AndroidWithKotlin.GridView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidwithkotlin.AndroidWithKotlin.ExpandableListView.CustomExpandableListAdapter
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ListItemGridViewBinding

internal class ImageListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val itemList: Array<String>?
) : ArrayAdapter<ImageListAdapter.ItemViewHolder>(context, resource) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: ListItemGridViewBinding


    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        var holder: ItemViewHolder
        if (convertView == null) {
            itemBinding = ListItemGridViewBinding.inflate(inflater)
            convertView = itemBinding.root
            holder = ItemViewHolder()
            holder.name = itemBinding.textView
            holder.icon = itemBinding.icon
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
        holder.name!!.text = this.itemList!![position]
        holder.icon!!.setImageResource(R.mipmap.ic_launcher_round)
        return convertView

    }

    internal class ItemViewHolder {
        var name: TextView? = null
        var icon: ImageView? = null

    }
}