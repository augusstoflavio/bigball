package com.augusto.bigball.ui.features.home.bets.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Match(match: Match, onClick: () -> Unit) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(8.dp)
    ) {

        var modifier = Modifier.clickable(onClick = onClick)
        modifier = if (match.performed) {
            modifier
                .alpha(0.6f)
                .background(color = Color.LightGray)
        } else {
            modifier.background(color = Color.Transparent)
        }
        modifier = modifier.padding(16.dp)

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Team(
                    modifier = Modifier.weight(1f),
                    team = match.homeTeam
                )

                Scoreboard(
                    modifier = Modifier.weight(1f),
                    bet = match.bet,
                    result = match.result
                )

                Team(
                    modifier = Modifier.weight(1f),
                    team = match.visitingTeam
                )
            }

            Spacer(Modifier.height(12.dp))

            Text(text = match.date, style = MaterialTheme.typography.overline)
        }

    }
}

data class Match(
    val performed: Boolean,
    val bet: Scoreboard,
    val result: Scoreboard?,
    val homeTeam: Team,
    val visitingTeam: Team,
    val date: String
)