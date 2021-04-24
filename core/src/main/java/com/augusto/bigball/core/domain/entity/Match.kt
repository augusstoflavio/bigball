package com.augusto.bigball.core.domain.entity

import java.time.ZonedDateTime

data class Match (
    val id: Int,
    val homeTeam: Team,
    val visitingTeam: Team,
    val date: ZonedDateTime,
    val golsHomeTeam: Int?,
    val golsVisitingTeam: Int?,
    val bet: Bet?
)