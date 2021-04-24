package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.entity.Match
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.MatchRepository

class GetMatchs(private val matchRepository: MatchRepository) {

    suspend fun invoke(currentPage: Int): Result<List<Match>> {
        return matchRepository.getMatchs(currentPage)
    }
}