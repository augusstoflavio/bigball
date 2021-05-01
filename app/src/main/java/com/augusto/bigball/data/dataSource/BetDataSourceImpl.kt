package com.augusto.bigball.data.dataSource

import com.augusto.bigball.core.data.dataSource.BetDataSource
import com.augusto.bigball.core.domain.entity.Bet
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.data.api.helper.safeCall
import com.augusto.bigball.data.api.request.BetRequest
import com.augusto.bigball.data.api.service.MatchService

class BetDataSourceImpl(private val matchService: MatchService): BetDataSource {

    override suspend fun toBet(match: Int, bet: Bet): Result<Boolean> = safeCall {
        matchService.bet(
            BetRequest(
                golsHomeTeam = bet.golsHomeTeam,
                golsVisitingTeam = bet.golsVisitingTeam
            ),
            match
        )

        return@safeCall true
    }
}