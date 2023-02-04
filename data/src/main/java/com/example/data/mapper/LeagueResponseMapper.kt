package com.example.data.mapper

import com.example.data.remote.response.*
import com.example.domain.model.*

fun LeagueResponse.mapToModel() = LeagueModel(
    count = this.count,
    competition = this.competition?.mapToModel(),
    matches = this.matches.map { it.mapToModel() } as ArrayList<MatchModel>
)

fun Competition.mapToModel() = CompetitionModel(
    id, area?.mapToModel(), name, code, plan, lastUpdated
)

fun Area.mapToModel() = AreaModel(id, name)

fun Match.mapToModel() = MatchModel(id = this.id,
    season = this.season?.mapToModel(),
    utcDate = utcDate,
    status = status,
    matchday = matchday,
    stage = stage,
    group = group,
    lastUpdated = lastUpdated,
    odds = this.odds?.mapToModel(),
    score = this.score?.mapToModel(),
    homeTeam = this.homeTeam?.mapToModel(),
    awayTeam = this.awayTeam?.mapToModel(),
    referees = this.referees.map { it.mapToModel() } as ArrayList<RefereesModel>)

fun Season.mapToModel() = SeasonModel(id, startDate, endDate, currentMatchday)

fun Odds.mapToModel() = OddsModel(msg)

fun Score.mapToModel() = ScoreModel(
    winner,
    duration,
    fullTime = this.fullTime?.mapToModel(),
    halfTime = this.halfTime?.mapToModel(),
    extraTime = this.extraTime?.mapToModel(),
    penalties = this.penalties?.mapToModel()
)

fun FullTime.mapToModel() = FullTimeModel(homeTeam, awayTeam)

fun HalfTime.mapToModel() = HalfTimeModel(homeTeam, awayTeam)

fun ExtraTime.mapToModel() = ExtraTimeModel(homeTeam, awayTeam)

fun Penalties.mapToModel() = PenaltiesModel(homeTeam, awayTeam)

fun HomeTeam.mapToModel() = HomeTeamModel(id, name)

fun AwayTeam.mapToModel() = AwayTeamModel(id, name)

fun Referees.mapToModel() = RefereesModel(id, name, role, nationality)