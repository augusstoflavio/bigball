package com.augusto.bigball.core.domain.repository

import com.augusto.bigball.core.domain.entity.Player
import com.augusto.bigball.core.domain.entity.PlayerPoints
import com.augusto.bigball.core.domain.entity.Result

interface ClassificationRepository {
    suspend fun getClassification(): Result<List<PlayerPoints>>
}
