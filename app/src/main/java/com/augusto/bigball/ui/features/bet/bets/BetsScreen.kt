package com.augusto.bigball.ui.features.bet.bets

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.augusto.bigball.presentation.Loading
import com.augusto.bigball.ui.theme.BigBallTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.augusto.bigball.R
import com.augusto.bigball.ui.features.auth.signup.SignupEvent

@Preview(showBackground = true)
@Composable
fun BetsScreen() {
    BigBallTheme {
        Scaffold() {
            Surface() {
                Box() {

                    Column() {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth().padding(9.dp)
                        ) {
                            Text(text = "Realizadas", style = MaterialTheme.typography.button)

                            Switch(
                                checked = false,
                                onCheckedChange = { },
                                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.primaryVariant)
                            )
                        }

                        LazyColumn() {

                            // Add 5 items
                            items(95) { index ->
                                Card(elevation = 4.dp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(9.dp),
                                    border = BorderStroke(1.dp, Color.Black),
                                    shape = RoundedCornerShape(8.dp)) {

                                    var modifier = Modifier.clickable {  }
                                    modifier = if (index > 5) {
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
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Image(
                                                    painter = painterResource(R.drawable.ic_flamengo),
                                                    contentDescription = "Flamengo"
                                                )
                                                Text(text = "Flamengo", style = MaterialTheme.typography.subtitle1)
                                            }
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Text(text = "1 - 1", style = MaterialTheme.typography.h6)
                                                Text(text = "5 - 0", style = MaterialTheme.typography.overline)
                                            }
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Image(
                                                    painter = painterResource(R.drawable.ic_palmeiras),
                                                    contentDescription = "Palmeiras"
                                                )
                                                Text(text = "Palmeiras", style = MaterialTheme.typography.subtitle1)
                                            }
                                        }

                                        Spacer(Modifier.height(12.dp))

                                        Text(text = "13/10/1992 13:55", style = MaterialTheme.typography.overline)
                                    }

                                }
                            }
                        }
                    }


                    Loading()
                }
            }
        }
    }
}