package com.augusto.bigball.data.api.response

import com.squareup.moshi.Json

data class SigninResponse (
    @field:Json(name = "api_key")
    var apiKey: String
)