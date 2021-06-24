package com.augusto.bigball.core.domain.useCase

import com.augusto.bigball.core.domain.repository.AuthRepository

class IsLoggedIn(private val authRepository: AuthRepository) {

    operator fun invoke(): Boolean {
        return authRepository.isLoggedIn()
    }
}