package com.example.androidwithkotlin.Switch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivitySwitchBinding

class Switch : AppCompatActivity() {

    private lateinit var binding: ActivitySwitchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchBinding.inflate(layoutInflater)
        val viw = binding.root
        setContentView(viw)

        setSwitchChangedListener()
    }

    private fun setSwitchChangedListener() {
        binding.swithchId.setOnCheckedChangeListener { _, isChecked ->
            val msg = getString(if (isChecked) R.string.on else R.string.off)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            binding.swithchId.text = msg
        }
    }
}