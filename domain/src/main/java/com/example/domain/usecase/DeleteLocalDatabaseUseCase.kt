package com.example.domain.usecase

import com.example.domain.repository.LeagueRepository

class DeleteLocalDatabaseUseCase(private val repository: LeagueRepository) {
    suspend operator fun invoke() = repository.deleteMatchesFromLocalDB()
}