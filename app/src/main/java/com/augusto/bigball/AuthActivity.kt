package com.augusto.bigball

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity : AppCompatActivity() {

    private val _viewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val actions = remember(navController) { Actions(navController) }

            NavHost(navController = navController, startDestination = Destinations.Signin) {
                composable(Destinations.Signin) {
                    SigninScreen(
                        authViewModel = _viewModel,
                        toSignup = actions.toSignup
                    )
                }
                composable(Destinations.Signup) {
                    SignupScreen(
                        authViewModel = _viewModel
                    )
                }
            }
        }
    }
}