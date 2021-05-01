package com.augusto.bigball.data.dataSource

import com.augusto.bigball.core.data.dataSource.AuthDataSource
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.data.api.helper.safeCall
import com.augusto.bigball.data.api.request.SigninRequest
import com.augusto.bigball.data.api.request.SignupRequest
import com.augusto.bigball.data.api.service.AuthService

class AuthDataSourceImpl(private val authService: AuthService): AuthDataSource {

    override suspend fun signin(email: String, password: String): Result<String> = safeCall {
        return@safeCall authService.signin(
            SigninRequest(email, password)
        ).body()!!.apiKey
    }

    override suspend fun signup(name: String, email: String, password: String, passwordConfirmation: String): Result<Boolean> = safeCall {
        authService.signup(
            SignupRequest(name, email, password, passwordConfirmation)
        ).body()!!

        return@safeCall true
    }
}