package com.example.data.repository

import com.example.data.mapper.mapToModel
import com.example.data.remote.api.LeagueAPI
import com.example.domain.model.LeagueModel
import com.example.domain.repository.LeagueRepository

class LeagueRepositoryImpl(private val apiService: LeagueAPI) : LeagueRepository {
    override suspend fun getMatches(): LeagueModel? {
        return apiService.getMatches().body()?.mapToModel()

    }

}