package com.bangkit.capstone.managerku.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.mainToolbar)
        supportActionBar?.elevation = 0F
        setupNavigationController()
    }

    private fun setupNavigationController() {

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.dashboard_navigation,
            R.id.product_navigation,
            R.id.scan_navigation,
            R.id.inventory_navigation,
            R.id.profile_navigation
        ).build()

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        binding?.bottomNavbar?.setupWithNavController(navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }
}