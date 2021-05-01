package com.augusto.bigball.data.dataSource

import com.augusto.bigball.core.data.dataSource.ClassificationDataSource
import com.augusto.bigball.core.domain.entity.Player
import com.augusto.bigball.core.domain.entity.PlayerPoints
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.data.api.helper.safeCall
import com.augusto.bigball.data.api.service.ClassificationService

class ClassificationDataSourceImpl(private val classificationService: ClassificationService): ClassificationDataSource {

    override suspend fun getClassification(): Result<List<PlayerPoints>> = safeCall {
        return@safeCall classificationService.getClassification().body()!!.map {
            PlayerPoints(
                player = Player(it.player),
                points = it.points
            )
        }
    }
}