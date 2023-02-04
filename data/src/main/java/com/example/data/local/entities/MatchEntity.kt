package com.example.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

object DataBase {
    const val TableName = "match"
}

@Entity(tableName = DataBase.TableName)
data class MatchEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @ColumnInfo(name = "date")
    val utcDate: String? = null,
    @ColumnInfo(name = "status")
    val status: String? = null,
    @ColumnInfo(name = "homeTeam")
    val homeTeam: String? = null,
    @ColumnInfo(name = "homeTeamScore")
    val homeTeamScore: Int? = null,
    @ColumnInfo(name = "awayTeam")
    val awayTeam: String? = null,
    @ColumnInfo(name = "awayTeamScore")
    val awayTeamScore: Int? = null,
)