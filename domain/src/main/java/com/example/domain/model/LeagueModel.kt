package com.example.domain.model

data class LeagueModel(
    val count: Int? = null,
    val competition: CompetitionModel? = CompetitionModel(),
    val matches: ArrayList<MatchModel> = arrayListOf(),
)