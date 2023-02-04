package com.example.data.repository

import com.example.data.local.room.LeagueDatabase
import com.example.data.mapper.mapToEntity
import com.example.data.mapper.mapToModel
import com.example.data.remote.api.LeagueAPI
import com.example.domain.model.MatchModel
import com.example.domain.repository.LeagueRepository

class LeagueRepositoryImpl(
    private val apiService: LeagueAPI,
    private val localDatabase: LeagueDatabase,
) : LeagueRepository {
    override suspend fun fetchMatchesFromApi() = apiService.getMatches().body()?.mapToModel()
    override suspend fun saveMatchToDB(matchModel: MatchModel) = localDatabase.leagueDao().insert(matchModel.mapToEntity())
    override suspend fun getMatchesFromLocalDB() = localDatabase.leagueDao().getAllFavouriteMovies().map { it.mapToModel() }
    override suspend fun deleteMatchesFromLocalDB() = localDatabase.leagueDao().deleteAllFavouriteMovies()

}