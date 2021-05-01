package com.augusto.bigball.data.api.service

import com.augusto.bigball.data.api.response.PlayerPointsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ClassificationService {

    @GET("player/classification")
    suspend fun getClassification(): Response<List<PlayerPointsResponse>>
}