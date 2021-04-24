package com.augusto.bigball.core.data.repository

import com.augusto.bigball.core.data.dataSource.MatchDataSource
import com.augusto.bigball.core.domain.entity.Match
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.MatchRepository

class MatchRepositoryImpl(private val matchDataSource: MatchDataSource) : MatchRepository {

    override suspend fun getMatchs(currentPage: Int): Result<List<Match>> {
        return matchDataSource.getMatchs(currentPage)
    }
}