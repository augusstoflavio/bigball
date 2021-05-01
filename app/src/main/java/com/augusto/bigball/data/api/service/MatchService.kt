package com.augusto.bigball.data.api.service

import com.augusto.bigball.data.api.request.BetRequest
import com.augusto.bigball.data.api.response.GetMatchsResponse
import retrofit2.Response
import retrofit2.http.*

interface MatchService {

    @POST("player/match/{matchId}")
    suspend fun bet(@Body betRequest: BetRequest, @Path("matchId") matchId: Int): Response<Unit>

    @GET("player/match")
    suspend fun getMatchs(@Query("page") page: Int): Response<GetMatchsResponse>
}