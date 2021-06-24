package com.augusto.bigball.data.api.request

import com.squareup.moshi.Json

//TODO moshi is not converting fields on request
data class SignupRequest (
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "password_confirmation")
    val password_confirmation: String
)