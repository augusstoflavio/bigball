package com.augusto.bigball.ui.navigation

import com.augusto.bigball.helper.SingleLiveEvent

class NavigationManager {

    var commands = SingleLiveEvent<NavigationCommand>()

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}