package com.augusto.bigball.ui.features.home.classification

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.augusto.bigball.R
import com.augusto.bigball.presentation.Loading
import com.augusto.bigball.ui.theme.BigBallTheme

@Preview(showBackground = true)
@Composable
fun ClassificationScreen() {
    BigBallTheme {
        Scaffold() {
            Surface() {
                Box(modifier = Modifier.padding(6.dp)) {

                    Column {
                        Text(text = "Classificação", style = MaterialTheme.typography.h6)

                        Spacer(modifier = Modifier.height(6.dp))

                        LazyColumn {
                            items(15) { index ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 6.dp, bottom = 6.dp)
                                        .border(
                                            BorderStroke(1.dp, Color.Black),
                                            RoundedCornerShape(8.dp)
                                        )
                                        .padding(6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Box {
                                        Image(
                                            painter = painterResource(R.drawable.images),
                                            contentDescription = "User",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .width(50.dp)
                                                .height(50.dp)
                                        )
                                        Text(text = index.toString() + "ª",
                                            modifier = Modifier.clip(CircleShape)
                                                                .background(color = MaterialTheme.colors.primaryVariant)
                                                                .padding(4.dp)
                                                                .align(Alignment.BottomEnd),
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            style = MaterialTheme.typography.overline,
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(18.dp))
                                    Text(text = "Augusto Flávio", style = MaterialTheme.typography.h5)

                                    Spacer(modifier = Modifier.width(18.dp))

                                    Text(text = "15 pts", style = MaterialTheme.typography.h6)
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