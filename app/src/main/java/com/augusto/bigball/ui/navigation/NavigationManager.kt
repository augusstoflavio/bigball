package com.augusto.bigball.ui.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    var commands = MutableStateFlow(NavigationDirections.Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}