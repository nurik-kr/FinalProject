package kg.nurik.finalproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.ActivityMainBinding
import kg.nurik.finalproject.utils.setupWithNavController
import kg.nurik.finalproject.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navGraphId = listOf(
            R.navigation.allgames_nav,
            R.navigation.mygames_nav,
            R.navigation.commands_nav,
            R.navigation.tournaments_nav
        )
        binding.bottomNavigation.setupWithNavController(
            navGraphIds = navGraphId,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        ).observe(this, Observer {
            navController = it
        })
    }

    override fun onBackPressed() {
        navController.popBackStack()
    }
}