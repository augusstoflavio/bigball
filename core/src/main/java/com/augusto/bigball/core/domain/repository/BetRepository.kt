package com.augusto.bigball.core.domain.repository

import com.augusto.bigball.core.domain.entity.Bet
import com.augusto.bigball.core.domain.entity.Result

interface BetRepository {
    suspend fun toBet(matchId: Int, bet: Bet): Result<Boolean>
}
