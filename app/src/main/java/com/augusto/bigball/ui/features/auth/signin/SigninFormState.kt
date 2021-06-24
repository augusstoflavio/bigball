package com.augusto.bigball.ui.features.auth.signin

data class SigninFormState(
    var errorEmail: Int? = null,
    var errorPassword: Int? = null,
    var email: String? = null,
    var password: String? = null,
    var isLoading: Boolean = false,
    var error: String? = null
) {
    fun isValid(): Boolean = errorEmail == null && errorPassword == null
}