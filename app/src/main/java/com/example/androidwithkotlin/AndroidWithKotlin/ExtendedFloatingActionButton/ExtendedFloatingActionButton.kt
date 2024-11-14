package com.example.androidwithkotlin.AndroidWithKotlin.ExtendedFloatingActionButton

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityExtendedFloatingActionButtonBinding

class ExtendedFloatingActionButton : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityExtendedFloatingActionButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtendedFloatingActionButtonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupFabButtons()
    }

    private fun setupFabButtons() {
        binding.fabMenuActions.shrink()
        binding.fabMenuActions.setOnClickListener(this)
        binding.fabMenuAddAlarm.setOnClickListener(this)
        binding.fabMenuAddPerson.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab_menu_actions -> {
                expandOrCollapseFAB()
            }

            R.id.fab_menu_add_alarm -> {
                showToast("Hello from Add Alarm Button")

            }

            R.id.fab_menu_add_person -> {
                showToast("Hello from Add Person Button")
            }

        }
    }

    private fun showToast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun expandOrCollapseFAB() {
        if (binding.fabMenuActions.isExtended) {
            binding.fabMenuActions.shrink()
            binding.fabMenuAddAlarm.hide()
            binding.fabMenuAddAlarmText.visibility = View.GONE
            binding.fabMenuAddPerson.hide()
            binding.fabMenuAddPersonText.visibility = View.GONE
        } else {
            binding.fabMenuActions.extend()
            binding.fabMenuAddAlarm.show()
            binding.fabMenuAddAlarmText.visibility = View.VISIBLE
            binding.fabMenuAddPerson.show()
            binding.fabMenuAddPersonText.visibility = View.VISIBLE
        }
    }

}