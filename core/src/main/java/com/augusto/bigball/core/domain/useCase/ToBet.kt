package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.entity.Bet
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.BetRepository

class ToBet(private val betRepository: BetRepository) {

    suspend operator fun invoke(matchId: Int, bet: Bet): Result<Boolean> {
        return betRepository.toBet(matchId, bet)
    }
}