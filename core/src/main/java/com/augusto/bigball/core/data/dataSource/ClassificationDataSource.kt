package com.augusto.bigball.core.data.dataSource

import com.augusto.bigball.core.domain.entity.PlayerPoints
import com.augusto.bigball.core.domain.entity.Result

interface ClassificationDataSource {
    suspend fun getClassification(): Result<List<PlayerPoints>>

}
