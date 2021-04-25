package com.augusto.bigball.core.domain.entity

import java.time.ZonedDateTime

data class Bet (
    val golsHomeTeam: Int,
    val golsVisitingTeam: Int,
    val date: ZonedDateTime
)
