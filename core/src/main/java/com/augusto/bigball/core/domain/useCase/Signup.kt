package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.AuthRepository

class Signup(private val authRepository: AuthRepository) {

    suspend operator fun invoke(name: String, email: String, password: String): Result<Boolean> {
        return authRepository.signup(name, email, password)
    }
}