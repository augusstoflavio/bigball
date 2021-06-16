package com.augusto.bigball

import androidx.navigation.NavHostController

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