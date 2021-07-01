package com.augusto.bigball.ui.features.bet.bets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.augusto.bigball.presentation.Loading
import com.augusto.bigball.ui.features.bet.bets.component.Match
import com.augusto.bigball.ui.theme.BigBallTheme

@Preview(showBackground = true)
@Composable
fun BetsScreen(betsState: BetsState = BetsState()) {
    BigBallTheme {
        Scaffold() {
            Surface() {
                Box(modifier = Modifier.padding(6.dp)) {

                    Column() {
                        Text(text = "Apostas", style = MaterialTheme.typography.h6)

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(9.dp)
                        ) {
                            Text(text = "Realizadas", style = MaterialTheme.typography.button)

                            Switch(
                                checked = betsState.matchesPerformed,
                                onCheckedChange = { },
                                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.primaryVariant)
                            )
                        }

                        LazyColumn() {

                            betsState.matchs.forEach {
                                item {
                                    Match(match = it) {

                                    }
                                }
                            }
                        }
                    }

                    if (betsState.loading) {
                        Loading()
                    }
                }
            }
        }
    }
}

