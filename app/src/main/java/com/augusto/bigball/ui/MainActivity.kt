package com.augusto.bigball.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.augusto.bigball.ui.features.auth.AuthDirections
import com.augusto.bigball.ui.features.auth.signin.SigninScreen
import com.augusto.bigball.ui.features.auth.signup.SignupScreen
import com.augusto.bigball.ui.features.bet.BetDirections
import com.augusto.bigball.ui.features.bet.BetMainScreen
import com.augusto.bigball.ui.navigation.NavigationDirections
import com.augusto.bigball.ui.navigation.NavigationManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val navigationManager: NavigationManager by inject()
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startDestination = if (mainViewModel.isLoggedIn()) BetDirections.root.destination else AuthDirections.root.destination

        setContent {
            val navController = rememberNavController()

            navigationManager.commands.observe(this, {
                if (it == NavigationDirections.back) {
                    navController.popBackStack()
                } else if (it.destination.isNotEmpty()) {
                    navController.navigate(it.destination)
                }
            })

            NavHost(navController = navController, startDestination = startDestination) {
                navigation(startDestination = AuthDirections.signin.destination, route = AuthDirections.root.destination) {
                    composable(AuthDirections.signin.destination) {
                        SigninScreen(
                            signinViewModel = getViewModel()
                        )
                    }
                    composable(AuthDirections.signup.destination) {
                        SignupScreen(
                            signupViewModel = getViewModel()
                        )
                    }
                }
                navigation(startDestination = BetDirections.main.destination, route = BetDirections.root.destination) {
                    composable(BetDirections.main.destination) {
                        BetMainScreen()
                    }
                }
            }
        }
    }
}