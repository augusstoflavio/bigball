package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.repository.AuthRepository
import com.augusto.bigball.core.domain.entity.Result

class Signin(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<String> {
        val result = authRepository.signin(email, password)
        if (result is Result.Success) {
            authRepository.saveUser(email, result.data)
        }
        return result
    }
}