package com.example.domain.repository

import com.example.domain.model.LeagueModel

interface LeagueRepository {
    suspend fun getMatches(): LeagueModel?
}