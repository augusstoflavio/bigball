package com.augusto.bigball

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.augusto.bigball.ui.navigation.NavigationDirections
import com.augusto.bigball.ui.navigation.NavigationManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AuthActivity : AppCompatActivity() {

    val navigationManager: NavigationManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val actions = remember(navController) { Actions(navController) }

            navigationManager.commands.collectAsState().value.also { command ->
                if (command.destination.isNotEmpty()) {
                    navController.navigate(command.destination)
                }
            }

            NavHost(navController = navController, startDestination = AuthDirections.signin.destination) {
                composable(AuthDirections.signin.destination) {
                    val vm = getViewModel<SigninViewModel>()
                    SigninScreen(
                        signinFormState = vm.signinFormState,
                        handleEvent = vm::handleEvent
                    )
                }
                composable(AuthDirections.signup.destination) {
                    val vm = getViewModel<SignupViewModel>()
                    SignupScreen(
                        signupViewModel = vm,
                        toBack = actions.navigateUp
                    )
                }
            }
        }
    }
}