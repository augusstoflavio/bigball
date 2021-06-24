package com.augusto.bigball.ui.features.auth.signin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.augusto.bigball.R
import com.augusto.bigball.presentation.ErrorDialog
import com.augusto.bigball.presentation.InputText
import com.augusto.bigball.presentation.Loading
import com.augusto.bigball.presentation.PrimaryButton
import com.augusto.bigball.ui.theme.BigBallTheme

@Composable
fun SigninScreen(signinFormState: SigninFormState, handleEvent: (signinEvent: SigninEvent) -> Unit) {
    BigBallTheme {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {

                    Spacer(modifier = Modifier.height(94.dp))

                    Logo()

                    Spacer(modifier = Modifier.height(58.dp))

                    InputText(
                        label = stringResource(id = R.string.email),
                        value = signinFormState.email,
                        error = if (signinFormState.errorEmail != null) stringResource(
                            id = signinFormState.errorEmail!!
                        ) else null,
                        enabled = !signinFormState.isLoading,
                        onValueChange = {
                            handleEvent(SigninEvent.EmailChanged(it))
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    InputText(
                        label = stringResource(id = R.string.password),
                        value = signinFormState.password,
                        visualTransformation = PasswordVisualTransformation(),
                        error = if (signinFormState.errorPassword != null) stringResource(
                            id = signinFormState.errorPassword!!
                        ) else null,
                        enabled = !signinFormState.isLoading,
                        onValueChange = {
                            handleEvent(SigninEvent.PasswordChanged(it))
                        },
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.signin),
                        enabled = !signinFormState.isLoading && signinFormState.isValid()
                    ) {
                        handleEvent(SigninEvent.Signin)
                    }

                    Spacer(modifier = Modifier.height(73.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.cadastre_se),
                            Modifier.clickable {
                                handleEvent(SigninEvent.Signup)
                            },
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                if (signinFormState.isLoading) {
                    Loading()
                }

                if (!signinFormState.error.isNullOrEmpty()) {
                    ErrorDialog(title = stringResource(id = R.string.signin), message = signinFormState.error!!) {
                        handleEvent(SigninEvent.DismissErrorDialog)
                    }
                }

            }
        }
    }
}