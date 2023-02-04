package com.example.premierleague.di

import com.example.domain.repository.LeagueRepository
import com.example.domain.usecase.DeleteLocalDatabaseUseCase
import com.example.domain.usecase.FetchMatchesFromApiUseCase
import com.example.domain.usecase.GetMatchesFromLocalUseCase
import com.example.domain.usecase.SaveMatchToLocalUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideFetchMatchesFromApiUseCase(repository: LeagueRepository) = FetchMatchesFromApiUseCase(repository)

    @Provides
    @Singleton
    fun provideSaveMatchToLocalUseCase(repository: LeagueRepository) = SaveMatchToLocalUseCase(repository)

    @Provides
    @Singleton
    fun provideGetMatchesFromLocalUseCase(repository: LeagueRepository) = GetMatchesFromLocalUseCase(repository)

    @Provides
    @Singleton
    fun provideDeleteMatchesFromLocalUseCase(repository: LeagueRepository) = DeleteLocalDatabaseUseCase(repository)
}