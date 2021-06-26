package com.augusto.bigball.ui.features.bet

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.augusto.bigball.R
import com.augusto.bigball.ui.features.bet.bets.BetsScreen
import com.augusto.bigball.ui.theme.BigBallTheme

@Composable
fun BetMainScreen() {
    val navController2 = rememberNavController()

    val items = listOf(
        TabItem.Bets,
        TabItem.Classification,
        TabItem.Profile
    )

    val currentRoute = remember { mutableStateOf(BetDirections.bets.destination) }

    BigBallTheme {
        Scaffold(bottomBar = {
            BottomNavigation(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White,
            ) {
                items.forEach { tabItem ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = tabItem.icon, contentDescription = stringResource(id = tabItem.title)) },
                        label = { Text(stringResource(id = tabItem.title)) },
                        selected = tabItem.command.destination == currentRoute.value,
                        onClick = {
                            currentRoute.value = tabItem.command.destination
                            navController2.navigate(tabItem.command.destination)
                        }
                    )
                }
            }
        }) {
            NavHost(
                navController2,
                startDestination = BetDirections.bets.destination,
                modifier = Modifier.padding(bottom = 50.dp)
            ) {
                composable(BetDirections.bets.destination) {
                    BetsScreen()
                }
                composable(BetDirections.classification.destination) {
                    Text(text = stringResource(id = R.string.classification))
                }
                composable(BetDirections.profile.destination) {
                    Text(text = stringResource(id = R.string.profile))
                }
            }
        }
    }
}