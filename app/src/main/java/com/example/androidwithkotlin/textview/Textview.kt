package com.example.androidwithkotlin.textview

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityTextviewBinding

class Textview : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityTextviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customSpanFont()

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textviewId2 -> {
                Toast.makeText(applicationContext, "clicked on Hello message", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun customSpanFont() {
        val firstWord = "Hello"
        val secondWord = "World!"

        val redForegroundColorSpan = ForegroundColorSpan(resources.getColor(R.color.purple_200))
        val ssb = SpannableStringBuilder(firstWord)

        ssb.setSpan(redForegroundColorSpan, 0, ssb.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        ssb.append(" ")

        val strikethroughSpan = StrikethroughSpan()

        ssb.append(secondWord)
        ssb.setSpan(
            strikethroughSpan,
            ssb.length - secondWord.length,
            ssb.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )


        binding.spanText.text = ssb


    }

}