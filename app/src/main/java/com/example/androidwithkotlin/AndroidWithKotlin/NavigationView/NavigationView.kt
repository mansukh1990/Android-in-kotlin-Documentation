package com.example.androidwithkotlin.AndroidWithKotlin.NavigationView

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityNavigationViewBinding

class NavigationView : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationViewBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment), binding.drawerLayout)

        setupActionBar(navController, appBarConfiguration)
        setupNavigationMenu(navController)

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.navDrawer.setNavigationItemSelectedListener { menuitem ->
            menuitem.isChecked = !menuitem.isChecked
            when (menuitem.itemId) {
                R.id.nav_gallery -> {
                    navController.navigate(R.id.action_homeFragment_to_galleryFragment)
                }

                R.id.nav_slideshow -> {
                    navController.navigate(R.id.action_homeFragment_to_slideShowFragment)
                }
            }
            Toast.makeText(
                applicationContext,
                menuitem.title.toString() + "Selected ",
                Toast.LENGTH_SHORT
            ).show()
            closeDrawer()
            true

        }
    }

    private fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun setupNavigationMenu(navController: NavController) {
        binding.navDrawer.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    private fun setupActionBar(
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}