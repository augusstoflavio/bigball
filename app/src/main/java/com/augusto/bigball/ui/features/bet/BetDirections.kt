package com.augusto.bigball.ui.features.bet

import androidx.navigation.compose.NamedNavArgument
import com.augusto.bigball.ui.navigation.NavigationCommand

object BetDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet"
    }

    val main  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet.navigation"
    }

    val bets  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet.navigation.bets"
    }

    val classification = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet.navigation.classification"
    }

    val profile  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet.navigation.profile"
    }
}