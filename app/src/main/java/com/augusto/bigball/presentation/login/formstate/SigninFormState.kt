package com.augusto.bigball.presentation.login.formstate

/**
 * Data validation state of the login form.
 */
data class SigninFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null
)