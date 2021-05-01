package com.augusto.bigball.data.api.request

import com.squareup.moshi.Json

data class SignupRequest (
    @Json(name = "name")
    var name: String,
    @Json(name = "email")
    var email: String,
    @Json(name = "password")
    var password: String,
    @Json(name = "password_confirmation")
    var passwordConfirmation: String
)