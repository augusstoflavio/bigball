package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.entity.PlayerPoints
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.ClassificationRepository

class GetClassification(private val classificationRepository: ClassificationRepository) {

    suspend fun invoke(): Result<List<PlayerPoints>> {
        return classificationRepository.getClassification()
    }
}