package com.augusto.bigball

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import com.augusto.bigball.data.validator.EmailValidator
import com.augusto.bigball.presentation.bases.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class SigninViewModel(
    private val defaultDispatcher: CoroutineDispatcher,
    private val emailValidator: EmailValidator
) : BaseViewModel(defaultDispatcher) {

    val logado = MutableLiveData<Boolean>()

    var email by mutableStateOf<String?>(null)
        private set

    var password by mutableStateOf<String?>(null)
        private set

    var signinFormState by mutableStateOf(SigninFormState())
        private set

    var loadingForm by mutableStateOf(false)
        private set

    private fun validFields() {
        signinFormState = SigninFormState(
            errorEmail = getErrorEmail(),
            errorPassword = getErrorPassword()
        )
    }

    private fun getErrorEmail(): Int? {
        if (email.isNullOrEmpty()) {
            return R.string.required_email
        } else if (!emailValidator.isValid(email = email!!)) {
            return R.string.invalid_email
        }

        return null
    }

    private fun getErrorPassword(): Int? {
        if (password.isNullOrEmpty()) {
            return R.string.required_password
        } else if (password!!.length < 5) {
            return R.string.invalid_size_password
        }

        return null
    }

    fun onChangeEmail(email: String) {
        this.email = email
        signinFormState.errorEmail = getErrorEmail()
    }

    fun onChangePassword(password: String) {
        this.password = password
        signinFormState.errorPassword = getErrorPassword()
    }

    fun onLogin() {
        loadingForm = true

        validFields()

        if (!signinFormState.isValid()) {
            loadingForm = false
            return
        }

//        logado.postValue(true)
//        loadingForm = false
    }
}

data class SigninFormState(
    var errorEmail: Int? = null,
    var errorPassword: Int? = null,
) {

    fun isValid(): Boolean = errorEmail == null && errorPassword == null
}