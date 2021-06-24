package com.augusto.bigball.core.data.repository

import com.augusto.bigball.core.data.dataSource.AuthDataSource
import com.augusto.bigball.core.data.dataSource.AuthLocalDataSource
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.core.domain.repository.AuthRepository

class AuthRepositoryImpl(private val authDataSource: AuthDataSource, private val authLocalDataSource: AuthLocalDataSource) : AuthRepository {

    override suspend fun signin(email: String, password: String): Result<String> {
        return authDataSource.signin(email, password)
    }

    override suspend fun signup(name: String, email: String, password: String, passwordConfirmation: String): Result<Boolean> {
        return authDataSource.signup(name, email, password, passwordConfirmation)
    }

    override fun isLoggedIn(): Boolean {
        return authLocalDataSource.isLoggedIn()
    }

    override suspend fun saveUser(name: String, token: String) {
        return authLocalDataSource.saveUser(name, token)
    }

    override suspend fun logoff() {
        return authLocalDataSource.logoff()
    }

    override suspend fun getToken(): String? {
        return authLocalDataSource.getToken()
    }
}