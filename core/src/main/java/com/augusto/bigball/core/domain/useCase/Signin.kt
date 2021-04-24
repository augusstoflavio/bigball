package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.repository.AuthRepository
import com.augusto.bigball.core.domain.entity.Result

class Signin(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<Boolean> {
        return authRepository.signin(email, password)
    }
}