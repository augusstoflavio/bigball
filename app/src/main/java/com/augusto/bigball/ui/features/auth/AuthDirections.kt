package com.augusto.bigball.ui.features.auth

import androidx.navigation.compose.NamedNavArgument
import com.augusto.bigball.ui.navigation.NavigationCommand

object AuthDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "auth"
    }

    val signup  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "auth.signup"
    }

    val signin = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "auth.signin"
    }
}