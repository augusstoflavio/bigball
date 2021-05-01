package com.augusto.bigball.data.api.response

import com.squareup.moshi.Json

data class PlayerPointsResponse (
        @Json(name = "player")
        var player: String,
        @Json(name = "points")
        var points: Int
)
