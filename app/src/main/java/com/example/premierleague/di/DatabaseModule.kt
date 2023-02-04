package com.example.premierleague.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.entities.DataBase
import com.example.data.local.room.LeagueDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context,
    ) = Room.databaseBuilder(
        app,
        LeagueDatabase::class.java,
        DataBase.TableName
    ).build()
}
