package com.augusto.bigball.ui.features.bet.bets.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Scoreboard(modifier: Modifier = Modifier, bet: Scoreboard, result: Scoreboard?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = bet.homeTeamGoals.toString() + " - " + bet.visitingTeamGoals.toString(), style = MaterialTheme.typography.h6)

        if (result != null) {
            Text(text = result.homeTeamGoals.toString() + " - " + result.visitingTeamGoals.toString(), style = MaterialTheme.typography.overline)
        }
    }
}



data class Scoreboard(
    val homeTeamGoals: Int,
    val visitingTeamGoals: Int,
)