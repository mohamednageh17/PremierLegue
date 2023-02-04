package com.example.domain.model

data class CompetitionModel(
    val id: Int? = null,
    val area: AreaModel? = AreaModel(),
    val name: String? = null,
    val code: String? = null,
    val plan: String? = null,
    val lastUpdated: String? = null,
)

data class AreaModel(
    val id: Int? = null,
    val name: String? = null,
)