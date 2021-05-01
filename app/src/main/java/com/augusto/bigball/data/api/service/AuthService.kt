package com.augusto.bigball.data.api.service

import com.augusto.bigball.data.api.request.SigninRequest
import com.augusto.bigball.data.api.request.SignupRequest
import com.augusto.bigball.data.api.response.SigninResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signin")
    suspend fun signin(@Body signinRequest: SigninRequest): Response<SigninResponse>

    @POST("client/auth/signup")
    suspend fun signup(@Body signupRequest: SignupRequest): Response<Unit>
}