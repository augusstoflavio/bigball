package com.augusto.bigball

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.augusto.bigball.data.validator.EmailValidator
import com.augusto.bigball.presentation.bases.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class SigninViewModel(
    private val defaultDispatcher: CoroutineDispatcher,
    private val emailValidator: EmailValidator,
    private val navigationManager: NavigationManager
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

        signinFormState = signinFormState.copy(isLoading = false)
        navigationManager.navigate(NavigationDirections.signup)
    }

    fun handleEvent(signinEvent: SigninEvent) {
        when (signinEvent) {
            is SigninEvent.Signin -> {
                onLogin()
            }
            is SigninEvent.Signup -> {
                navigationManager.navigate(NavigationDirections.signup)
            }
            is SigninEvent.EmailChanged -> {
                onChangeEmail(signinEvent.email)
            }
            is SigninEvent.PasswordChanged -> {
                onChangePassword(signinEvent.password)
            }
        }
    }
}

data class SigninFormState(
    var errorEmail: Int? = null,
    var errorPassword: Int? = null,
    var email: String? = null,
    var password: String? = null,
    var isLoading: Boolean = false
) {
    fun isValid(): Boolean = errorEmail == null && errorPassword == null
}