package com.augusto.bigball.core.data.dataSource

import com.augusto.bigball.core.domain.entity.Match
import com.augusto.bigball.core.domain.entity.Result

interface MatchDataSource {
    suspend fun getMatchs(currentPage: Int): Result<List<Match>>
}
