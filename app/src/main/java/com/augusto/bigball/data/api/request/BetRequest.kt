package com.augusto.bigball.data.api.request

import com.squareup.moshi.Json

data class BetRequest (
    @Json(name = "goals_home_team")
    var golsHomeTeam: Int,
    @Json(name = "goals_visiting_team")
    var golsVisitingTeam: Int
)
