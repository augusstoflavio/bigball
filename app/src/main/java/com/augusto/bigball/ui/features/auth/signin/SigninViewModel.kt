package com.augusto.bigball.ui.features.auth.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.augusto.bigball.R
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.useCase.Signin
import com.augusto.bigball.data.validator.EmailValidator
import com.augusto.bigball.presentation.bases.BaseViewModel
import com.augusto.bigball.ui.features.auth.AuthDirections
import com.augusto.bigball.ui.features.bet.BetDirections
import com.augusto.bigball.ui.navigation.NavigationManager
import kotlinx.coroutines.CoroutineDispatcher

class SigninViewModel(
    defaultDispatcher: CoroutineDispatcher,
    private val emailValidator: EmailValidator,
    private val navigationManager: NavigationManager,
    private val signin: Signin
) : BaseViewModel(defaultDispatcher) {

    var signinFormState by mutableStateOf(SigninFormState())
        private set

    private fun validFields() {
        signinFormState = signinFormState.copy(
            errorPassword = getErrorPassword(signinFormState.password),
            errorEmail = getErrorPassword(signinFormState.email)
        )
    }

    private fun getErrorEmail(email: String?): Int? {
        if (email.isNullOrEmpty()) {
            return R.string.required_email
        } else if (!emailValidator.isValid(email = email)) {
            return R.string.invalid_email
        }

        return null
    }

    private fun getErrorPassword(password: String?): Int? {
        if (password.isNullOrEmpty()) {
            return R.string.required_password
        } else if (password.length < 5) {
            return R.string.invalid_size_password
        }

        return null
    }

    private fun onChangeEmail(email: String) {
        signinFormState = signinFormState.copy(email = email, errorEmail = getErrorEmail(email = email))
    }

    private fun onChangePassword(password: String) {
        signinFormState = signinFormState.copy(password = password, errorPassword = getErrorPassword(password = password))
    }

    private fun onLogin() {
        signinFormState = signinFormState.copy(isLoading = true)

        validFields()

        if (!signinFormState.isValid()) {
            signinFormState = signinFormState.copy(isLoading = false)
            return
        }

        run {
            when (val result = signin.invoke(signinFormState.email!!, signinFormState.password!!)) {
                is Result.Success -> {
                    navigationManager.navigate(BetDirections.root)
                }
                is Result.Failure -> {
                    signinFormState = signinFormState.copy(error = result.error.message)
                }
            }
            signinFormState = signinFormState.copy(isLoading = false)
        }
    }

    fun handleEvent(signinEvent: SigninEvent) {
        when (signinEvent) {
            is SigninEvent.Signin -> {
                onLogin()
            }
            is SigninEvent.Signup -> {
                navigationManager.navigate(AuthDirections.signup)
            }
            is SigninEvent.EmailChanged -> {
                onChangeEmail(signinEvent.email)
            }
            is SigninEvent.PasswordChanged -> {
                onChangePassword(signinEvent.password)
            }
            is SigninEvent.DismissErrorDialog -> {
                signinFormState = signinFormState.copy(error = null)
            }
        }
    }
}