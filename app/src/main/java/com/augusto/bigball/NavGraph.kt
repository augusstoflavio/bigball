package com.augusto.bigball

import androidx.navigation.NavHostController

object Destinations {
    const val Signup = "signup"
    const val Signin = "signin"
}

class Actions(navController: NavHostController) {
    val toSignup: () -> Unit = {
        navController.navigate(Destinations.Signup)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}