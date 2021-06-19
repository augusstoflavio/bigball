package com.augusto.bigball.ui.navigation

import androidx.navigation.compose.NamedNavArgument

interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}