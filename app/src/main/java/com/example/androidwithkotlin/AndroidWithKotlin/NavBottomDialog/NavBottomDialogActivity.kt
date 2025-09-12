package com.example.androidwithkotlin.AndroidWithKotlin.NavBottomDialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityNavBottomDialogBinding


@Suppress("DEPRECATION")
class NavBottomDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBottomDialogBinding
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNavBottomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar,
            R.string.open_nav, R.string.close_nav
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_layout, HomeNavFragment())
                .commit()
            binding.bottomNavigationViewDialog.selectedItemId = R.id.nav_home
        }

        binding.bottomNavigationViewDialog.background = null
        binding.bottomNavigationViewDialog.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeNavFragment())
                R.id.shorts -> replaceFragment(ShortsFragment())
                R.id.subscriptions -> replaceFragment(SubscriptionsFragment())
                R.id.library -> replaceFragment(LibraryFragment())
            }
            true
        }
        binding.navView.setNavigationItemSelectedListener  { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> replaceFragment(HomeNavFragment())
                R.id.nav_settings -> replaceFragment(SettingNavFragment())
                R.id.nav_share -> replaceFragment(ShareNavFragment())
                R.id.nav_about -> replaceFragment(AboutNavFragment())
                R.id.nav_logout -> {
                    logout()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


        binding.fab.setOnClickListener { showBottomDialog() }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .commit()
    }

    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayout)

        val videoLayout = dialog.findViewById<LinearLayout?>(R.id.layoutVideo)
        val shortsLayout = dialog.findViewById<LinearLayout?>(R.id.layoutShorts)
        val liveLayout = dialog.findViewById<LinearLayout?>(R.id.layoutLive)
        val cancelButton: ImageView = dialog.findViewById(R.id.cancelButton)

        if (videoLayout != null) {
            videoLayout.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    dialog.dismiss()
                    Toast.makeText(
                        this@NavBottomDialogActivity,
                        "Upload a Video is clicked",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })
        }

        if (shortsLayout != null) {
            shortsLayout.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    dialog.dismiss()
                    Toast.makeText(
                        this@NavBottomDialogActivity,
                        "Create a short is Clicked",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })
        }

        if (liveLayout != null) {
            liveLayout.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    dialog.dismiss()
                    Toast.makeText(
                        this@NavBottomDialogActivity,
                        "Go live is Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }

        cancelButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                dialog.dismiss()
            }
        })

        dialog.show()
        dialog.getWindow()!!
            .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.getWindow()!!.getAttributes().windowAnimations = R.style.DialogAnimation
        dialog.getWindow()!!.setGravity(Gravity.BOTTOM)
    }

    private fun logout() {
        Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show()
        // TODO: Clear session and navigate to LoginActivity
    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}