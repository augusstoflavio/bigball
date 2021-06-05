package com.augusto.bigball

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.augusto.bigball.presentation.InputText
import com.augusto.bigball.presentation.Loading
import com.augusto.bigball.presentation.PrimaryButton
import com.augusto.bigball.ui.theme.BigBallTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val _viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }

        setupObservables()
    }

    private fun setupObservables() {
        _viewModel.error.observe(this, {
            it?.let {
                Toast.makeText(this, it.error.message, Toast.LENGTH_SHORT).show()
            }
        })

        _viewModel.logado.observe(this, {
            if (it) {
                Toast.makeText(this, "Login realizado", Toast.LENGTH_SHORT).show()
            }
        })
    }

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
                            label = stringResource(id = R.string.email),
                            value = _viewModel.email,
                            error = if (_viewModel.loginFormState.errorEmail != null) stringResource(
                                id = _viewModel.loginFormState.errorEmail!!
                            ) else null,
                            enabled = !_viewModel.loadingForm,
                            onValueChange = {
                                _viewModel.onChangeEmail(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        InputText(
                            label = stringResource(id = R.string.password),
                            value = _viewModel.password,
                            visualTransformation = PasswordVisualTransformation(),
                            error = if (_viewModel.loginFormState.errorPassword != null) stringResource(
                                id = _viewModel.loginFormState.errorPassword!!
                            ) else null,
                            enabled = !_viewModel.loadingForm,
                            onValueChange = {
                                _viewModel.onChangePassword(it)
                            },
                        )

                        Spacer(modifier = Modifier.height(24.dp))
                        
                        PrimaryButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.signin),
                            enabled = !_viewModel.loadingForm && _viewModel.loginFormState.isValid()
                        ) {
                            _viewModel.onLogin()
                        }
                    }

                    if (_viewModel.loadingForm) {
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
}