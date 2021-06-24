package com.augusto.bigball.ui.features.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.augusto.bigball.R
import com.augusto.bigball.presentation.*
import com.augusto.bigball.ui.theme.BigBallTheme

@Composable
fun SignupScreen(signupFormState: SignupFormState, handleEvent: (SignupEvent) -> Unit) {
    BigBallTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.signup))
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            handleEvent(SignupEvent.Signin)
                        }) {
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
                            value = signupFormState.name,
                            error = if (signupFormState.errorName != null) stringResource(
                                id = signupFormState.errorName!!
                            ) else null,
                            enabled = !signupFormState.isLoading,
                            onValueChange = {
                                handleEvent(SignupEvent.NameChanged(it))
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputEmail(
                            label = stringResource(id = R.string.email),
                            value = signupFormState.email,
                            error = if (signupFormState.errorEmail != null) stringResource(
                                id = signupFormState.errorEmail!!
                            ) else null,
                            enabled = !signupFormState.isLoading,
                            onValueChange = {
                                handleEvent(SignupEvent.EmailChanged(it))
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputPassword(
                            label = stringResource(id = R.string.password),
                            value = signupFormState.password,
                            error = if (signupFormState.errorPassword != null) stringResource(
                                id = signupFormState.errorPassword!!
                            ) else null,
                            enabled = !signupFormState.isLoading,
                            onValueChange = {
                                handleEvent(SignupEvent.PasswordChanged(it))
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputPassword(
                            label = stringResource(id = R.string.password_confirmation),
                            value = signupFormState.passwordConfirmation,
                            error = if (signupFormState.errorPasswordConfirmation != null) stringResource(
                                id = signupFormState.errorPasswordConfirmation!!
                            ) else null,
                            enabled = !signupFormState.isLoading,
                            onValueChange = {
                                handleEvent(SignupEvent.PasswordConfirmationChanged(it))
                            }
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        PrimaryButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Cadastrar",
                            enabled = !signupFormState.isLoading && signupFormState.isValid()
                        ) {
                            handleEvent(SignupEvent.Signup)
                        }
                    }

                    if (signupFormState.isLoading) {
                        Loading()
                    }

                    if (!signupFormState.error.isNullOrEmpty()) {
                        ErrorDialog(title = stringResource(id = R.string.signup), message = signupFormState.error!!) {
                            handleEvent(SignupEvent.DismissErrorDialog)
                        }
                    }

                    if (signupFormState.registered) {
                        ErrorDialog(title = stringResource(id = R.string.signup), message = stringResource(id = R.string.registered)) {
                            handleEvent(SignupEvent.Signin)
                        }
                    }
                }
            }
        }
    }
}