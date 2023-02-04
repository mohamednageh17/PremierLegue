package com.example.domain.usecase

import com.example.domain.model.DisplayedMatchModel
import com.example.domain.repository.LeagueRepository

class FetchMatchesFromApiUseCase(private val repository: LeagueRepository) {
    suspend operator fun invoke(): List<DisplayedMatchModel> {
        val matches = repository.getMatches()?.matches
        val list = mutableListOf<DisplayedMatchModel>()
        matches?.distinctBy {
            it.utcDate?.substringBefore("T")
        }?.forEach { item ->
            list.add(
                DisplayedMatchModel(item.utcDate, matches.filter { it.utcDate?.substringBefore("T") == item.utcDate?.substringBefore("T") })
            )
        }
        return list
    }
}