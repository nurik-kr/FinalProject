package kg.nurik.finalproject.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.ActivityMainBinding
import kg.nurik.finalproject.ui.bottomNav.allGames.AllGamesFragment
import kg.nurik.finalproject.ui.bottomNav.myCommands.MyCommandsFragment
import kg.nurik.finalproject.ui.bottomNav.myGames.MyGamesFragment
import kg.nurik.finalproject.ui.bottomNav.tournaments.TournamentsFragment
import kg.nurik.finalproject.ui.bottomNav.viewPager.ViewPagerAdapter
import kg.nurik.finalproject.utils.setupWithNavController
import kg.nurik.finalproject.utils.viewBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_all_games.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    //    private val vm by viewModel<MainViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupBottomNav()
        setupDrawer()
        setupListeners()
    }

    private fun setupDrawer() {
        val drawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                setTitle(R.string.football)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.options)
            }
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        DrawerClickListeners()
    }

    private fun DrawerClickListeners() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            Toast.makeText(this, "clickable", Toast.LENGTH_LONG).show()
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
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
        )

//        val adapter = ViewPagerAdapter(supportFragmentManager)
//        ViewPager.adapter = adapter
//        adapter.addFragment(AllGamesFragment())
//        adapter.addFragment(MyGamesFragment())
//        adapter.addFragment(MyCommandsFragment())
//        adapter.addFragment(TournamentsFragment())
    }

    private fun setupListeners() {
//        bottomNavigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.all_games -> ViewPager.currentItem = 0
//                R.id.my_games -> ViewPager.currentItem = 1
//                R.id.my_commands -> ViewPager.currentItem = 2
//                R.id.tournaments -> ViewPager.currentItem = 3
//            }
//            true
//        }
    }
}