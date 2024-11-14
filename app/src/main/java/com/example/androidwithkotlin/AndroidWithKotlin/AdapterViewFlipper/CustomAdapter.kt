package com.example.androidwithkotlin.AndroidWithKotlin.AdapterViewFlipper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidwithkotlin.databinding.ItemAdapterViewFlipperBinding

class CustomAdapter internal constructor(
    context: Context,
    private val nameList: Array<String>,
    private val imageList: IntArray
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(position: Int): Any {
        return nameList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var convertView = view
        val holder: ViewHolder
        if (convertView == null) {
            val binding = ItemAdapterViewFlipperBinding.inflate(inflater)
            convertView = binding.root
            holder = ViewHolder()
            holder.imageView = binding.image
            holder.textView = binding.name
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.textView!!.text = nameList[position]
        holder.imageView!!.setBackgroundResource(imageList[position])
        return convertView
    }

    inner class ViewHolder {
        internal var imageView: ImageView? = null
        internal var textView: TextView? = null
    }
}