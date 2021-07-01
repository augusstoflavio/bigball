package com.augusto.bigball.ui.features.home

import androidx.navigation.compose.NamedNavArgument
import com.augusto.bigball.ui.navigation.NavigationCommand

object HomeDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home"
    }

    val main  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home.navigation"
    }

    val bets  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home.navigation.bets"
    }

    val classification = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home.navigation.classification"
    }

    val profile  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home.navigation.profile"
    }
}