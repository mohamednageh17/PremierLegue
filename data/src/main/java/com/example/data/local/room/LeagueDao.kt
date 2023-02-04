package com.example.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.local.entities.DataBase
import com.example.data.local.entities.MatchEntity

@Dao
interface LeagueDao {
    @Insert
    fun insert(movie: MatchEntity)

    @Delete
    fun delete(movie: MatchEntity)

    @Query("delete from ${DataBase.TableName}")
    fun deleteAllFavouriteMovies()

    @Query("select * from ${DataBase.TableName}")
    fun getAllFavouriteMovies(): List<MatchEntity>

    @Query("select * from ${DataBase.TableName} where id=:id")
    fun checkMovieIsFavourite(id: Long): MatchEntity
}