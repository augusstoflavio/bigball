package com.augusto.bigball.ui.features.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.augusto.bigball.R
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.useCase.Signup
import com.augusto.bigball.data.validator.EmailValidator
import com.augusto.bigball.presentation.bases.BaseViewModel
import com.augusto.bigball.ui.navigation.NavigationDirections
import com.augusto.bigball.ui.navigation.NavigationManager
import kotlinx.coroutines.CoroutineDispatcher

class SignupViewModel(
    private val defaultDispatcher: CoroutineDispatcher,
    private val emailValidator: EmailValidator,
    private val navigationManager: NavigationManager,
    private val signup: Signup
) : BaseViewModel(defaultDispatcher) {

    var signupFormState by mutableStateOf(SignupFormState())
        private set

    private fun validFields() {
        signupFormState = signupFormState.copy(
            errorName = getErrorName(signupFormState.name),
            errorPassword = getErrorPassword(signupFormState.password),
            errorEmail = getErrorEmail(signupFormState.email),
            errorPasswordConfirmation = getErrorPasswordConfirmation(signupFormState.password, signupFormState.passwordConfirmation),
        )
    }

    private fun getErrorName(name: String?): Int? {
        if (name.isNullOrEmpty() || name.length < 3) {
            return R.string.required_name
        }

        return null
    }

    private fun getErrorPasswordConfirmation(password: String?, passwordConfirmation: String?): Int? {
        if (password != passwordConfirmation) {
            return R.string.required_same_passwords
        }

        return null
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

    private fun onChangeName(name: String) {
        signupFormState = signupFormState.copy(name = name, errorName = getErrorName(name = name))
    }

    private fun onChangeEmail(email: String) {
        signupFormState = signupFormState.copy(email = email, errorEmail = getErrorEmail(email = email))
    }

    private fun onChangePassword(password: String) {
        signupFormState = signupFormState.copy(password = password, errorPassword = getErrorPassword(password = password))
    }

    private fun onChangePasswordConfirmation(password: String) {
        signupFormState = signupFormState.copy(passwordConfirmation = password, errorPasswordConfirmation = getErrorPasswordConfirmation(signupFormState.password, passwordConfirmation = password))
    }

    fun onSignup() {
        signupFormState = signupFormState.copy(isLoading = true)

        validFields()

        if (!signupFormState.isValid()) {
            signupFormState = signupFormState.copy(isLoading = false)
            return
        }

        run {
            when (val result = signup.invoke(signupFormState.name!!, signupFormState.email!!, signupFormState.password!!, signupFormState.passwordConfirmation!!)) {
                is Result.Success -> {
                    signupFormState = signupFormState.copy(registered = true, isLoading = false)
                }
                is Result.Failure -> {
                    signupFormState = signupFormState.copy(error = result.error.message, isLoading = false)
                }
            }
        }
    }

    fun handleEvent(signupEvent: SignupEvent) {
        when (signupEvent) {
            is SignupEvent.Signin -> {
                signupFormState = SignupFormState()
                navigationManager.navigate(NavigationDirections.back)
            }
            is SignupEvent.Signup -> {
                onSignup()
            }
            is SignupEvent.NameChanged -> {
                onChangeName(signupEvent.name)
            }
            is SignupEvent.EmailChanged -> {
                onChangeEmail(signupEvent.email)
            }
            is SignupEvent.PasswordChanged -> {
                onChangePassword(signupEvent.password)
            }
            is SignupEvent.PasswordConfirmationChanged -> {
                onChangePasswordConfirmation(signupEvent.password)
            }
            is SignupEvent.DismissErrorDialog -> {
                signupFormState = signupFormState.copy(error = null)
            }
        }
    }
}