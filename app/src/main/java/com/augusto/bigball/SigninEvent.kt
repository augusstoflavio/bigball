package com.augusto.bigball

sealed class SigninEvent {
    object Signin : SigninEvent()
    object Signup : SigninEvent()
    data class EmailChanged(val email: String) : SigninEvent()
    data class PasswordChanged(val password: String) : SigninEvent()
}
