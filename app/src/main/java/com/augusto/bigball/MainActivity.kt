package com.augusto.bigball

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.augusto.bigball.ui.theme.BigBallTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val _viewModel: LoginViewModel by viewModel()

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
                Box {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)) {

                        Spacer(modifier = Modifier.height(94.dp))

                        Logo()

                        Spacer(modifier = Modifier.height(58.dp))

                        InputText(
                            label = "E-mail",
                            value = _viewModel.email,
                            error = _viewModel.loginFormState.errorEmail,
                            enabled = !_viewModel.loadingForm,
                            onValueChange = {
                                _viewModel.onChangeEmail(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputText(
                            label = "Senha",
                            value = _viewModel.password,
                            visualTransformation = PasswordVisualTransformation(),
                            error = _viewModel.loginFormState.errorPassword,
                            enabled = !_viewModel.loadingForm,
                            onValueChange = {
                                _viewModel.onChangePassword(it)
                            },
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = { _viewModel.onLogin() },
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                            modifier = Modifier.fillMaxWidth(),
                            enabled = !_viewModel.loadingForm && _viewModel.loginFormState.isValid()
                        ) {
                            Text(text = "Entrar")
                        }
                    }

                    if (_viewModel.loadingForm) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(color = MaterialTheme.colors.secondary)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Logo() {
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
    }

    @Composable
    fun InputText(
        modifier: Modifier = Modifier,
        label: String,
        value: String?,
        error: String? = null,
        onValueChange: (String) -> Unit,
        enabled: Boolean = true,
        visualTransformation: VisualTransformation = VisualTransformation.None
    ) {
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = value ?: "",
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White, textColor = Color.Black),
            maxLines = 1,
            visualTransformation = visualTransformation,
            label = {
                Text(
                    text = if (!error.isNullOrEmpty()) error
                    else label
                )
            },
            enabled = enabled,
            isError = !error.isNullOrEmpty(),
        )
    }
}