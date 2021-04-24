package com.augusto.bigball.core.domain.entity

import java.time.ZonedDateTime

data class Bet (
    var golsHomeTeam: Int,
    var golsVisitingTeam: Int,
    var date: ZonedDateTime
)
