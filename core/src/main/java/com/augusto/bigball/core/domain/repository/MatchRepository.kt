package com.augusto.bigball.core.domain.repository

import com.augusto.bigball.core.domain.entity.Match
import com.augusto.bigball.core.domain.entity.Result

interface MatchRepository {
    suspend fun getMatchs(currentPage: Int): Result<List<Match>>
}
