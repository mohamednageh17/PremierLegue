package com.example.premiumlegue.di

import com.example.domain.repository.LeagueRepository
import com.example.domain.usecase.FetchMatchesFromApiUseCase
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
    fun provideFetchMatchesUseCase(repository: LeagueRepository)=FetchMatchesFromApiUseCase(repository)
}