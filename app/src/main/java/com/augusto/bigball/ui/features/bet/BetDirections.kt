package com.augusto.bigball.ui.features.bet

import androidx.navigation.compose.NamedNavArgument
import com.augusto.bigball.ui.navigation.NavigationCommand

object BetDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet"
    }

    val bets  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet.bets"
    }

    val classification = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "bet.classification"
    }
}