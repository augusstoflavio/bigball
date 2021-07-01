package com.augusto.bigball.ui.features.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.augusto.bigball.R
import com.augusto.bigball.ui.navigation.NavigationCommand

sealed class HomeTabItem(
    val command: NavigationCommand,
    val title: Int,
    val icon: ImageVector
) {
    object Bets : HomeTabItem(
        HomeDirections.bets, R.string.bets, Icons.Filled.Star
    )
    object Classification : HomeTabItem(
        HomeDirections.classification, R.string.classification, Icons.Filled.MilitaryTech
    )
    object Profile : HomeTabItem(
        HomeDirections.profile, R.string.profile, Icons.Filled.Face
    )
}