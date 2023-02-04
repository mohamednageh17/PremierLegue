package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("season") var season: Season? = Season(),
    @SerializedName("utcDate") var utcDate: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("matchday") var matchday: Int? = null,
    @SerializedName("stage") var stage: String? = null,
    @SerializedName("group") var group: String? = null,
    @SerializedName("lastUpdated") var lastUpdated: String? = null,
    @SerializedName("odds") var odds: Odds? = Odds(),
    @SerializedName("score") var score: Score? = Score(),
    @SerializedName("homeTeam") var homeTeam: HomeTeam? = HomeTeam(),
    @SerializedName("awayTeam") var awayTeam: AwayTeam? = AwayTeam(),
    @SerializedName("referees") var referees: ArrayList<Referees> = arrayListOf(),
)

data class Season(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("startDate") var startDate: String? = null,
    @SerializedName("endDate") var endDate: String? = null,
    @SerializedName("currentMatchday") var currentMatchday: Int? = null,
)

data class Odds(
    @SerializedName("msg") var msg: String? = null,
)

data class Score(
    @SerializedName("winner") var winner: String? = null,
    @SerializedName("duration") var duration: String? = null,
    @SerializedName("fullTime") var fullTime: FullTime? = FullTime(),
    @SerializedName("halfTime") var halfTime: HalfTime? = HalfTime(),
    @SerializedName("extraTime") var extraTime: ExtraTime? = ExtraTime(),
    @SerializedName("penalties") var penalties: Penalties? = Penalties(),
)


data class FullTime(
    @SerializedName("homeTeam") var homeTeam: Int? = null,
    @SerializedName("awayTeam") var awayTeam: Int? = null,
)

data class HalfTime(
    @SerializedName("homeTeam") var homeTeam: Int? = null,
    @SerializedName("awayTeam") var awayTeam: Int? = null,
)


data class ExtraTime(
    @SerializedName("homeTeam") var homeTeam: Int? = null,
    @SerializedName("awayTeam") var awayTeam: Int? = null,
)


data class Penalties(
    @SerializedName("homeTeam") var homeTeam: Int? = null,
    @SerializedName("awayTeam") var awayTeam: Int? = null,
)


data class HomeTeam(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
)

data class AwayTeam(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
)

data class Referees(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("role") var role: String? = null,
    @SerializedName("nationality") var nationality: String? = null,
)