package com.augusto.bigball.data.api.response

import com.augusto.bigball.core.domain.entity.Bet
import com.augusto.bigball.core.domain.entity.Match
import com.augusto.bigball.core.domain.entity.Team
import com.squareup.moshi.Json
import java.time.ZonedDateTime

data class GetMatchsResponse (
    @Json(name = "data")
    var data: List<MatchResponse>,
)

data class MatchResponse (
    @Json(name = "id")
    var id: Int,
    @Json(name = "home_team")
    var homeTeam: TeamResponse,
    @Json(name = "visiting_team")
    var visitingTeam: TeamResponse,
    @Json(name = "date")
    var date: ZonedDateTime,
    @Json(name = "goals_home_team")
    var goalsHomeTeam: Int?,
    @Json(name = "goals_visiting_team")
    var goalsVisitingTeam: Int?,
    @Json(name = "bet")
    var bet: BetResponse?,
) {
    fun toMatch(): Match {
        return Match(
            id = id,
            homeTeam = homeTeam.toTeam(),
            visitingTeam = visitingTeam.toTeam(),
            date = date,
            golsHomeTeam = goalsHomeTeam,
            golsVisitingTeam = goalsVisitingTeam,
            bet = if (bet != null) { bet!!.toBet() } else { null }
        )
    }
}

data class TeamResponse (
    @Json(name = "id")
    var id: Int,
    @Json(name = "name")
    var name: String,
    @Json(name = "icon")
    var icon: String,
    @Json(name = "initials")
    var initials: String,
) {
    fun toTeam(): Team {
        return Team(
            name = name,
            icon = icon,
            initials = initials
        )
    }
}

data class BetResponse (
    @Json(name = "id")
    var id: Int,
    @Json(name = "goals_home_team")
    var goalsHomeTeam: Int,
    @Json(name = "goals_visiting_team")
    var goalsVisitingTeam: Int,
    @Json(name = "date")
    var date: ZonedDateTime
) {
    fun toBet(): Bet {
        return Bet(
            golsHomeTeam = goalsHomeTeam,
            golsVisitingTeam = goalsVisitingTeam,
            date = date
        )
    }
}
