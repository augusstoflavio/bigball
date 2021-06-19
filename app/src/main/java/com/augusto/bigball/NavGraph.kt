package com.augusto.bigball

import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import com.augusto.bigball.ui.navigation.NavigationCommand
import kotlinx.coroutines.flow.MutableStateFlow


sealed class Screen(val route: String) {
    object Signup: Screen("signup")
    object Signin: Screen("signin")
}

class Actions(navController: NavHostController) {
    val toSignup: () -> Unit = {
        navController.navigate(Screen.Signup.route)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}