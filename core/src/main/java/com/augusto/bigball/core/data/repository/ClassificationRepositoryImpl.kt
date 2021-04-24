package com.augusto.bigball.core.data.repository

import com.augusto.bigball.core.data.dataSource.ClassificationDataSource
import com.augusto.bigball.core.domain.entity.PlayerPoints
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.ClassificationRepository

class ClassificationRepositoryImpl(private val classificationDataSource: ClassificationDataSource) : ClassificationRepository {

    override suspend fun getClassification(): Result<List<PlayerPoints>> {
        return classificationDataSource.getClassification()
    }
}