package com.augusto.bigball

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import com.augusto.bigball.data.validator.EmailValidator
import com.augusto.bigball.presentation.bases.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class SignupViewModel(
    private val defaultDispatcher: CoroutineDispatcher,
    private val emailValidator: EmailValidator
) : BaseViewModel(defaultDispatcher) {

    var signupFormState by mutableStateOf(SignupFormState())
        private set

    var name by mutableStateOf<String?>(null)
        private set

    var email by mutableStateOf<String?>(null)
        private set

    var password by mutableStateOf<String?>(null)
        private set

    var passwordConfirmation by mutableStateOf<String?>(null)
        private set

    val registered = MutableLiveData<Boolean>()

    var loadingForm by mutableStateOf(false)
        private set

    private fun validFields() {
        signupFormState = SignupFormState(
            errorName = getErrorName(),
            errorEmail = getErrorEmail(),
            errorPassword = getErrorPassword(),
            errorPasswordConfirmation = getErrorPasswordConfirmation(),
        )
    }

    private fun getErrorName(): Int? {
        return null
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

    private fun getErrorPasswordConfirmation(): Int? {
        return null
    }

    fun onChangeEmail(email: String) {
        this.email = email
        signupFormState.errorEmail = getErrorEmail()
    }

    fun onChangePassword(password: String) {
        this.password = password
        signupFormState.errorPassword = getErrorPassword()
    }

    fun onSignup() {
        loadingForm = true

        validFields()

        if (!signupFormState.isValid()) {
            loadingForm = false
            return
        }

//        logado.postValue(true)
//        loadingForm = false
    }
}


data class SignupFormState(
    var errorName: Int? = null,
    var errorEmail: Int? = null,
    var errorPassword: Int? = null,
    var errorPasswordConfirmation: Int? = null,
) {

    fun isValid(): Boolean = errorName == null &&
            errorEmail == null &&
            errorPassword == null &&
            errorPasswordConfirmation == null
}