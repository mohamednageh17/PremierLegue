package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("competition") var competition: Competition? = Competition(),
    @SerializedName("matches") var matches: ArrayList<Match> = arrayListOf(),
)
