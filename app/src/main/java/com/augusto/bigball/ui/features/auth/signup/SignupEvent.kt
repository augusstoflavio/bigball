package com.augusto.bigball.ui.features.auth.signup

sealed class SignupEvent {
    object Signin : SignupEvent()
    object Signup : SignupEvent()
    data class NameChanged(val name: String) : SignupEvent()
    data class EmailChanged(val email: String) : SignupEvent()
    data class PasswordChanged(val password: String) : SignupEvent()
    data class PasswordConfirmationChanged(val password: String) : SignupEvent()
}