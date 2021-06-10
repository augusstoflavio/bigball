package com.augusto.bigball

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.augusto.bigball.presentation.InputText
import com.augusto.bigball.presentation.Loading
import com.augusto.bigball.presentation.PrimaryButton
import com.augusto.bigball.ui.theme.BigBallTheme

@Composable
fun SigninScreen(authViewModel: AuthViewModel, toSignup: () -> Unit) {
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
                        label = stringResource(id = R.string.email),
                        value = authViewModel.email,
                        error = if (authViewModel.loginFormState.errorEmail != null) stringResource(
                            id = authViewModel.loginFormState.errorEmail!!
                        ) else null,
                        enabled = !authViewModel.loadingForm,
                        onValueChange = {
                            authViewModel.onChangeEmail(it)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    InputText(
                        label = stringResource(id = R.string.password),
                        value = authViewModel.password,
                        visualTransformation = PasswordVisualTransformation(),
                        error = if (authViewModel.loginFormState.errorPassword != null) stringResource(
                            id = authViewModel.loginFormState.errorPassword!!
                        ) else null,
                        enabled = !authViewModel.loadingForm,
                        onValueChange = {
                            authViewModel.onChangePassword(it)
                        },
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.signin),
                        enabled = !authViewModel.loadingForm && authViewModel.loginFormState.isValid()
                    ) {
                        authViewModel.onLogin()
                    }

                    Spacer(modifier = Modifier.height(73.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Cadastre-se",
                            Modifier.clickable {
                                toSignup()
                            },
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                if (authViewModel.loadingForm) {
                    Loading()
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
            text = stringResource(id = R.string.bolao_2021),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(R.drawable.ic_futebol_1),
            contentDescription = "Logo"
        )
    }
}