package com.augusto.bigball.data.dataSource

import com.augusto.bigball.core.data.dataSource.MatchDataSource
import com.augusto.bigball.core.domain.entity.*
import com.augusto.bigball.data.api.helper.safeCall
import com.augusto.bigball.data.api.service.MatchService

class MatchDataSourceImpl(private val matchService: MatchService): MatchDataSource {

    override suspend fun getMatchs(currentPage: Int): Result<List<Match>> = safeCall {
        return@safeCall matchService.getMatchs(currentPage).body()!!.data.map {
            it.toMatch()
        }
    }
}