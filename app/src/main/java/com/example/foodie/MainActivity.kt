package com.example.foodie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration= AppBarConfiguration(setOf(R.id.recipeFragment,R.id.foodJokeFragment,R.id.favoriteRecipeFragment))
        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()|| super.onSupportNavigateUp()
    }
}