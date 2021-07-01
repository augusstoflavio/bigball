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
import com.augusto.bigball.ui.features.bet.bets.BetsState
import com.augusto.bigball.ui.features.bet.bets.component.Match
import com.augusto.bigball.ui.features.bet.bets.component.Scoreboard
import com.augusto.bigball.ui.features.bet.bets.component.Team
import com.augusto.bigball.ui.features.bet.classification.ClassificationScreen
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
                    BetsScreen(
                        BetsState(
                            matchesPerformed = true,
                            matchs = listOf(
                                Match(
                                    performed = false,
                                    homeTeam = Team(
                                        name = "Flamengo",
                                        logo = R.drawable.ic_flamengo
                                    ),
                                    visitingTeam = Team(
                                        name = "Palmeiras",
                                        logo = R.drawable.ic_palmeiras
                                    ),
                                    bet = Scoreboard(
                                        homeTeamGoals = 1,
                                        visitingTeamGoals = 0
                                    ),
                                    result = Scoreboard(
                                        homeTeamGoals = 5,
                                        visitingTeamGoals = 0
                                    ),
                                    date = "13/10/1993 12:50"
                                ),
                                Match(
                                    performed = false,
                                    homeTeam = Team(
                                        name = "Flamengo",
                                        logo = R.drawable.ic_flamengo
                                    ),
                                    visitingTeam = Team(
                                        name = "Palmeiras",
                                        logo = R.drawable.ic_palmeiras
                                    ),
                                    bet = Scoreboard(
                                        homeTeamGoals = 1,
                                        visitingTeamGoals = 0
                                    ),
                                    result = Scoreboard(
                                        homeTeamGoals = 5,
                                        visitingTeamGoals = 0
                                    ),
                                    date = "13/10/1993 12:50"
                                )
                            )
                        )
                    )
                }
                composable(BetDirections.classification.destination) {
                    ClassificationScreen()
                }
                composable(BetDirections.profile.destination) {
                    Text(text = stringResource(id = R.string.profile))
                }
            }
        }
    }
}