package com.example.domain.model

data class MatchModel(
    val id: Int? = null,
    val season: SeasonModel? = SeasonModel(),
    val utcDate: String? = null,
    val status: String? = null,
    val matchday: Int? = null,
    val stage: String? = null,
    val group: String? = null,
    val lastUpdated: String? = null,
    val odds: OddsModel? = OddsModel(),
    val score: ScoreModel? = ScoreModel(),
    val homeTeam: HomeTeamModel? = HomeTeamModel(),
    val awayTeam: AwayTeamModel? = AwayTeamModel(),
    val referees: ArrayList<RefereesModel> = arrayListOf(),
)

data class SeasonModel(
    val id: Int? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val currentMatchday: Int? = null,
)

data class OddsModel(
    val msg: String? = null,
)

data class ScoreModel(
    val winner: String? = null,
    val duration: String? = null,
    val fullTime: FullTimeModel? = FullTimeModel(),
    val halfTime: HalfTimeModel? = HalfTimeModel(),
    val extraTime: ExtraTimeModel? = ExtraTimeModel(),
    val penalties: PenaltiesModel? = PenaltiesModel(),
)


data class FullTimeModel(
    val homeTeam: Int? = null,
    val awayTeam: Int? = null,
)

data class HalfTimeModel(
    val homeTeam: Int? = null,
    val awayTeam: Int? = null,
)

data class ExtraTimeModel(
    val homeTeam: Int? = null,
    val awayTeam: Int? = null,
)


data class PenaltiesModel(
    val homeTeam: Int? = null,
    val awayTeam: Int? = null,
)

data class HomeTeamModel(
    val id: Int? = null,
    val name: String? = null,
)

data class AwayTeamModel(
    val id: Int? = null,
    val name: String? = null,
)

data class RefereesModel(
    val id: Int? = null,
    val name: String? = null,
    val role: String? = null,
    val nationality: String? = null,
)
