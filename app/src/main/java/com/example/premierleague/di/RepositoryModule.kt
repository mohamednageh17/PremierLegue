package com.example.premierleague.di

import com.example.data.local.room.LeagueDatabase
import com.example.data.remote.api.LeagueAPI
import com.example.data.repository.LeagueRepositoryImpl
import com.example.domain.repository.LeagueRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideLeagueRepository(apiService: LeagueAPI, localDatabase: LeagueDatabase): LeagueRepository {
        return LeagueRepositoryImpl(apiService, localDatabase)
    }
}