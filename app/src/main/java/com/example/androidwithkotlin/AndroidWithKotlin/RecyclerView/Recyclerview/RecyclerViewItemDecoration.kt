package com.example.androidwithkotlin.AndroidWithKotlin.RecyclerView.Recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecoration(
    context: Context,
    resId: Int
) : RecyclerView.ItemDecoration() {

    private var mDevider: Drawable = ContextCompat.getDrawable(context, resId)!!

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val deviderLeftMargin: Int = 2
        val deviderRightMargin: Int = parent.width - 2

        for (i in 0 until parent.childCount) {
            if (i != parent.childCount) {
                val child: View = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams

                val deviderTop: Int = child.bottom + parent.marginBottom
                val deviderBottom: Int = deviderTop + mDevider.intrinsicHeight

                mDevider.setBounds(deviderLeftMargin, deviderTop, deviderRightMargin, deviderBottom)
                mDevider.draw(c)
            }
        }

    }
}