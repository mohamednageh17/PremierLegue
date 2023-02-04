package com.example.domain.repository

import com.example.domain.model.LeagueModel
import com.example.domain.model.MatchModel

interface LeagueRepository {
    suspend fun fetchMatchesFromApi(): LeagueModel?
    suspend fun saveMatchToDB(matchModel: MatchModel)
    suspend fun getMatchesFromLocalDB(): List<MatchModel>
    suspend fun deleteMatchesFromLocalDB()
}