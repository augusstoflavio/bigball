package com.augusto.bigball.ui.features.bet.bets.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun Team(modifier: Modifier = Modifier, team: Team) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(team.logo),
            contentDescription = team.name
        )
        Text(text = team.name, style = MaterialTheme.typography.subtitle1)
    }
}

data class Team(
    val name: String,
    val logo: Int,
)