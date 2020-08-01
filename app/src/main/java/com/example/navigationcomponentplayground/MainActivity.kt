package com.example.navigationcomponentplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set you Custom Toolbar
        setSupportActionBar(toolbar)
        // Set navigation graph to navigationView
        navigation_view.setupWithNavController(nav_host_fragment.findNavController())
        // Set item on drawerLayout
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstFragment,
                R.id.secondFragment,
                R.id.thirdFragment,
                R.id.forthFragment
            ), drawer_layout
        )
        setupActionBarWithNavController(
            nav_host_fragment.findNavController(), appBarConfiguration
        )


        // Set navigation graph to bottomNavigationView
        bottomNavigationView.setupWithNavController(nav_host_fragment.findNavController())


        // addOnDestinationChangedListener to navGraph (this work for both of drawerLayout & bottomNavigationView)
        nav_host_fragment.findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.forthFragment -> {
                    bottomNavigationView.visibility = View.GONE
                }
                else -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }

    }

    // This override fun is need to open drawerLayout
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}