package com.example.data.remote.api

import com.example.data.remote.response.LeagueResponse
import com.example.data.utils.EndPoints
import retrofit2.Response
import retrofit2.http.GET

interface LeagueAPI {
    @GET(EndPoints.MATCHES)
    suspend fun getMatches(): Response<LeagueResponse>
}