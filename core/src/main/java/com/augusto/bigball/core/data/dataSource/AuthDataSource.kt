package com.augusto.bigball.core.data.dataSource

import com.augusto.bigball.core.domain.entity.Result

interface AuthDataSource {
    suspend fun signin(email: String, password: String): Result<String>
    suspend fun signup(name: String, email: String, password: String, passwordConfirmation: String): Result<Boolean>
}
