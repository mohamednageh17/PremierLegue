package com.example.premiumlegue.di

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
    fun provideLeagueRepository(apiService: LeagueAPI):LeagueRepository{
        return LeagueRepositoryImpl(apiService)
    }
}