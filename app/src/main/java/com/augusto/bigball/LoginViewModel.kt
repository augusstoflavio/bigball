package com.augusto.bigball

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.augusto.bigball.data.validator.EmailValidator
import com.augusto.bigball.presentation.bases.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class LoginViewModel(
    private val defaultDispatcher: CoroutineDispatcher,
    private val emailValidator: EmailValidator
) : BaseViewModel(defaultDispatcher) {

    var email by mutableStateOf<String?>(null)
        private set

    var password by mutableStateOf<String?>(null)
        private set

    var loginFormState by mutableStateOf(LoginFormState())
        private set

    var loadingForm by mutableStateOf(false)
        private set

    private fun validFields() {
        loginFormState = LoginFormState(
            errorEmail = getErrorEmail(),
            errorPassword = getErrorPassword()
        )
    }

    private fun getErrorEmail(): String? {
        if (email.isNullOrEmpty()) {
            return "O e-mail deve ser o obrigatório"
        } else if (emailValidator.isValid(email = email ?: "")) {
            return "E-mail inválido"
        }

        return null
    }

    private fun getErrorPassword(): String? {
        if (password.isNullOrEmpty()) {
            return "A senha é obrigatória"
        } else if (password!!.length < 5) {
            return "A senha deverá ter mais de 5 caracteres"
        }

        return null
    }

    fun onChangeEmail(email: String) {
        this.email = email
        loginFormState.errorEmail = getErrorEmail()
    }

    fun onChangePassword(password: String) {
        this.password = password
        loginFormState.errorPassword = getErrorPassword()
    }

    fun onLogin() {
        loadingForm = true

        validFields()

        if (!loginFormState.isValid()) {
            loadingForm = false
            return
        }
    }
}

data class LoginFormState(
    var errorEmail: String? = null,
    var errorPassword: String? = null,
) {

    fun isValid(): Boolean = errorEmail == null && errorPassword == null
}