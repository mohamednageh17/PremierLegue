package com.example.data.mapper

import com.example.data.local.entities.MatchEntity
import com.example.domain.model.*

fun MatchModel.mapToEntity() = MatchEntity(
    id = this.id,
    utcDate = this.utcDate,
    status = this.status,
    homeTeam = this.homeTeam?.name,
    homeTeamScore = this.score?.fullTime?.homeTeam,
    awayTeam = this.awayTeam?.name,
    awayTeamScore = this.score?.fullTime?.awayTeam
)

fun MatchEntity.mapToModel() = MatchModel(
    id = this.id,
    utcDate = this.utcDate,
    status = this.status,
    homeTeam = HomeTeamModel(name = this.homeTeam),
    awayTeam = AwayTeamModel(name = this.awayTeam),
    score = ScoreModel(
        fullTime = FullTimeModel(homeTeam = this.homeTeamScore, awayTeam = this.awayTeamScore)
    )
)