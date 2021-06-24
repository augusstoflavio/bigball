package com.augusto.bigball.ui.features.auth.signup

data class SignupFormState(
    var errorName: Int? = null,
    var errorEmail: Int? = null,
    var errorPassword: Int? = null,
    var errorPasswordConfirmation: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var passwordConfirmation: String? = null,
    var isLoading: Boolean = false,
    var error: String? = null,
    var registered: Boolean = false
) {
    fun isValid(): Boolean =
            errorName == null &&
            errorEmail == null &&
            errorPassword == null &&
            errorPasswordConfirmation == null
}