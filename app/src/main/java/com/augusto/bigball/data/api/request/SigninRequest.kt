package com.augusto.bigball.data.api.request

import com.squareup.moshi.Json

data class SigninRequest (
    @Json(name = "email")
    var email: String,
    @Json(name = "password")
    var password: String,
)