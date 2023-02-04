package com.example.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.entities.MatchEntity

@Database(entities = [MatchEntity::class], version = 1)
abstract class LeagueDatabase : RoomDatabase() {
    abstract fun leagueDao(): LeagueDao
}


