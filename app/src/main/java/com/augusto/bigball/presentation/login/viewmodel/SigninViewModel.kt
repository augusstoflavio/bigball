package com.augusto.bigball.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.augusto.bigball.R
import com.augusto.bigball.core.domain.useCase.Signin
import com.augusto.bigball.data.local.SharedPreferencesDataSource
import com.augusto.bigball.presentation.bases.BaseViewModel
import com.augusto.bigball.presentation.login.formstate.SigninFormState
import kotlinx.coroutines.CoroutineDispatcher
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.data.validator.EmailValidator

class SigninViewModel(
    private val sharedPreferencesDataSource: SharedPreferencesDataSource,
    private val signin: Signin,
    private val emailValidator: EmailValidator,
    private val defaultDispatcher: CoroutineDispatcher
) : BaseViewModel(defaultDispatcher) {

    private val _loginForm = MutableLiveData<SigninFormState>()
    val signinFormState: LiveData<SigninFormState> = _loginForm

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    fun login(username: String, password: String) {
        if (!loginDataChanged(username, password)) {
            return
        }

        run {
            when (val response = signin(username, password)) {
                is Result.Success -> {
                    sharedPreferencesDataSource.saveUser(username, response.data)
                    _loginResult.postValue(true)
                }
                is Result.Failure -> {
                    _loginResult.postValue(false)
                    notifyFailure(response)
                }
            }
        }
    }

    private fun loginDataChanged(username: String, password: String): Boolean {
        if (!emailValidator.isValid(username)) {
            _loginForm.value = SigninFormState(usernameError = R.string.invalid_username)
            return false
        } else if (!isPasswordValid(password)) {
            _loginForm.value = SigninFormState(passwordError = R.string.invalid_password)
            return false
        }

        return true
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}