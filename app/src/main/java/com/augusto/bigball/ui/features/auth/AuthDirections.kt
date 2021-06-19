package com.augusto.bigball.ui.features.auth

import androidx.navigation.compose.NamedNavArgument
import com.augusto.bigball.ui.navigation.NavigationCommand

object AuthDirections {

    val signup  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "signup"

    }

    val signin = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "signin"
    }
}