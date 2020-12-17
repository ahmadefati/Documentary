package com.documentary.app.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.documentary.app.R
import com.documentary.app.ui.event.Event
import com.documentary.app.ui.event.EventObserver
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val navController: NavController get() = findNavController(R.id.nav_host_fragment)

    @Inject
    lateinit var builder: MutableLiveData<Event<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*  val appBarConfiguration = AppBarConfiguration(setOf(
              R.id.navigation_home,
              R.id.navigation_dashboard,
              R.id.navigation_notifications
          ))*/
        /*setupActionBarWithNavController(navController, appBarConfiguration)*/
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications -> {
                    navView.visibility = View.VISIBLE
                }

                else -> {
                    navView.visibility = View.GONE
                }
            }
        }

        builder.observe(this, EventObserver {
            /*if (!viewModel.isLoginFragment) {
                Log.i("Sorena", "Received $EVENT_UNAUTH")
                findNavController(R.id.navHostFragment).navigate(R.id.action_runFragment_to_loginFragment)
                viewModel.isLoginFragment = true
            }*/
        })
    }

    private fun subscribe() {
        viewModel.apply {
            liveData.observe(this@MainActivity, Observer { viewState ->
                viewState.name?.let {

                }
                viewState.token?.let { token ->
                    if (token.isEmpty() /*&& navController.currentDestination?.id != R.id.loginFragment*/) {
//                    navigateToSetupFragment()
                    }
                }
            })
        }
        /* viewModel.apply {
             liveData.observe(this@MainActivity, { viewState ->
                 viewState.name?.let {
                     tvToolbarTitle.text = "Welcome back $it!"
                 }

                 viewState.token?.let { token ->
                     if (token.isEmpty() && navController.currentDestination?.id != R.id.setupFragment) {
                         navigateToSetupFragment()
                     }
                 }
             })
         }*/
    }
}