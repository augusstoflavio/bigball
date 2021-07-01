package com.augusto.bigball.ui.features.home

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
import com.augusto.bigball.ui.features.home.bets.BetsScreen
import com.augusto.bigball.ui.features.home.bets.BetsState
import com.augusto.bigball.ui.features.home.bets.BetsViewModel
import com.augusto.bigball.ui.features.home.bets.component.Match
import com.augusto.bigball.ui.features.home.bets.component.Scoreboard
import com.augusto.bigball.ui.features.home.bets.component.Team
import com.augusto.bigball.ui.features.home.classification.ClassificationScreen
import com.augusto.bigball.ui.theme.BigBallTheme

@Composable
fun HomeScreen(betsViewModel: BetsViewModel) {
    HomeScreen(betsState = betsViewModel.betsState)
}

@Composable
private fun HomeScreen(betsState: BetsState) {
    val navController2 = rememberNavController()

    val items = listOf(
        HomeTabItem.Bets,
        HomeTabItem.Classification,
        HomeTabItem.Profile
    )

    val currentRoute = remember { mutableStateOf(HomeDirections.bets.destination) }

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
                startDestination = HomeDirections.bets.destination,
                modifier = Modifier.padding(bottom = 50.dp)
            ) {
                composable(HomeDirections.bets.destination) {
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
                composable(HomeDirections.classification.destination) {
                    ClassificationScreen()
                }
                composable(HomeDirections.profile.destination) {
                    Text(text = stringResource(id = R.string.profile))
                }
            }
        }
    }
}