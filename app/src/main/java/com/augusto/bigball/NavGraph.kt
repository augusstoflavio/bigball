package com.augusto.bigball

import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import kotlinx.coroutines.flow.MutableStateFlow

interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}

object NavigationDirections {

    val signup  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "signup"

    }

    val signin = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "signin"
    }

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""

    }
}

class NavigationManager {

    var commands = MutableStateFlow(NavigationDirections.Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}


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