package com.augusto.bigball.core.data.repository

import com.augusto.bigball.core.data.dataSource.BetDataSource
import com.augusto.bigball.core.domain.entity.Bet
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.BetRepository

class BetRepositoryImpl(private val betDataSource: BetDataSource) : BetRepository {

    override suspend fun toBet(matchId: Int, bet: Bet): Result<Boolean> {
        return betDataSource.toBet(matchId, bet)
    }
}