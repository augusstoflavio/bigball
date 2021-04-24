package com.augusto.bigball.core.data.dataSource

import com.augusto.bigball.core.domain.entity.Bet
import com.augusto.bigball.core.domain.entity.Result

interface BetDataSource {
    suspend fun toBet(match: Int, bet: Bet): Result<Boolean>

}
