package com.augusto.bigball.core.data.repository

import com.augusto.bigball.core.data.dataSource.AuthDataSource
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.AuthRepository

class AuthRepositoryImpl(private val authDataSource: AuthDataSource) : AuthRepository {

    override suspend fun signin(email: String, password: String): Result<String> {
        return authDataSource.signin(email, password)
    }

    override suspend fun signup(name: String, email: String, password: String): Result<Boolean> {
        return authDataSource.signup(name, email, password)
    }
}