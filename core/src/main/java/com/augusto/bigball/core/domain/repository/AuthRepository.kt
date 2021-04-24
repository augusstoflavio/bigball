package com.augusto.bigball.core.domain.repository

import com.augusto.bigball.core.domain.entity.Result

interface AuthRepository {
    suspend fun signin(email: String, password: String): Result<Boolean>
    suspend fun signup(email: String, email1: String, password: String): Result<Boolean>
}
