package com.augusto.bigball.ui.features.auth.signup

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