package com.augusto.bigball.ui.navigation

import androidx.navigation.compose.NamedNavArgument

object NavigationDirections {
    val Default = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
    }

    val back = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "back"
    }
}