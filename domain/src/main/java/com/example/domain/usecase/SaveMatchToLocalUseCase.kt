package com.example.domain.usecase

import com.example.domain.model.MatchModel
import com.example.domain.repository.LeagueRepository

class SaveMatchToLocalUseCase(private val repository: LeagueRepository) {
    suspend operator fun invoke(matchModel: MatchModel) = repository.saveMatchToDB(matchModel)
}