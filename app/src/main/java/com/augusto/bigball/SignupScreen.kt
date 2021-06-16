package com.augusto.bigball

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.augusto.bigball.presentation.InputText
import com.augusto.bigball.presentation.PrimaryButton
import com.augusto.bigball.ui.theme.BigBallTheme

@Composable
fun SignupScreen(signupViewModel: SignupViewModel, toBack: () -> Unit) {
    BigBallTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.cadastre_se))
                    },
                    navigationIcon = {
                        IconButton(onClick = toBack) {
                            Icon(Icons.Filled.ArrowBack,"")
                        }
                    },
                    backgroundColor = Color.DarkGray,
                    contentColor = Color.White
                )
            },
        ) {
            Surface(
                color = MaterialTheme.colors.primary
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {

                        Spacer(modifier = Modifier.height(90.dp))

                        InputText(
                            label = stringResource(id = R.string.name),
                            value = signupViewModel.email,
                            error = if (signupViewModel.signupFormState.errorEmail != null) stringResource(
                                id = signupViewModel.signupFormState.errorEmail!!
                            ) else null,
                            enabled = !signupViewModel.loadingForm,
                            onValueChange = {
                                signupViewModel.onChangeEmail(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputText(
                            label = stringResource(id = R.string.email),
                            value = signupViewModel.email,
                            error = if (signupViewModel.signupFormState.errorEmail != null) stringResource(
                                id = signupViewModel.signupFormState.errorEmail!!
                            ) else null,
                            enabled = !signupViewModel.loadingForm,
                            onValueChange = {
                                signupViewModel.onChangeEmail(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputText(
                            label = stringResource(id = R.string.password),
                            value = signupViewModel.email,
                            error = if (signupViewModel.signupFormState.errorEmail != null) stringResource(
                                id = signupViewModel.signupFormState.errorEmail!!
                            ) else null,
                            enabled = !signupViewModel.loadingForm,
                            onValueChange = {
                                signupViewModel.onChangeEmail(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputText(
                            label = stringResource(id = R.string.password_confirmation),
                            value = signupViewModel.email,
                            error = if (signupViewModel.signupFormState.errorEmail != null) stringResource(
                                id = signupViewModel.signupFormState.errorEmail!!
                            ) else null,
                            enabled = !signupViewModel.loadingForm,
                            onValueChange = {
                                signupViewModel.onChangeEmail(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        PrimaryButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Cadastrar",
                            enabled = !signupViewModel.loadingForm && signupViewModel.signupFormState.isValid()
                        ) {
                            signupViewModel.onSignup()
                        }
                    }
                }
            }
        }
    }
}