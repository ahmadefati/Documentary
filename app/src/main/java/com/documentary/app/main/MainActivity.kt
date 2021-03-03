package com.documentary.app.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.documentary.app.R
import com.documentary.app.ui.event.Event
import com.documentary.app.ui.event.EventObserver
import com.documentary.base.Constants
import com.documentary.base.utils.DeepLink
import com.documentary.view.safeNavigate
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
        initView()
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                navController.graph.startDestination, R.id.homePageFragment, R.id.repo_dashboard, R.id.notification_dashboard -> {
                    navView.visibility = View.VISIBLE
                }
                else -> {
                    navController.graph.startDestination
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

    private fun initView() {
        viewModel.apply {
            // When user logs out then navigate to home page. Then condition means that
            // we're NOT inside of Home page && Splash screen.
            safeNavigate(
                navController,
                DeepLink.Builder()
                    .module(Constants.MODULE_UI_HOME)
                    .fragment(Constants.HOME_PAGE_FRAGMENT)
                    .build(),
                R.id.homePageFragment
            )
        }

    }

}