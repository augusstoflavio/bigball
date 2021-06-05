package com.augusto.bigball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.augusto.bigball.ui.theme.BigBallTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainActivityScreen() {
        BigBallTheme {
            Surface(
                color = MaterialTheme.colors.primary
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)) {


                    Spacer(modifier = Modifier.height(94.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Bolão 2021",
                            style = MaterialTheme.typography.h5
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Image(
                            painter = painterResource(R.drawable.ic_futebol_1),
                            contentDescription = "Logo"
                        )
                    }

                    Spacer(modifier = Modifier.height(58.dp))

                    InputText(label = "E-mail", value = "", error = null, onValueChange = {

                    })

                    Spacer(modifier = Modifier.height(16.dp))

                    InputText(label = "Senha", value = "", onValueChange = {

                    })

                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Entrar")
                    }
                }
            }
        }
    }

    @Composable
    fun InputText(
        modifier: Modifier = Modifier,
        label: String,
        value: String?,
        error: String? = null,
        onValueChange: (String) -> Unit,
    ) {
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = value ?: "",
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            maxLines = 1,
            label = {
                Text(
                    text = if (!error.isNullOrEmpty()) error
                    else label
                )
            },
            isError = !error.isNullOrEmpty(),
        )
    }
}