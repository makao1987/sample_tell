package com.example.sample_tell.di

import android.content.Context
import androidx.room.Room
import com.example.sample_tell.data.dao.CallHistoryDao
import com.example.sample_tell.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()

    @Provides
    fun provideCallHistoryDao(db: AppDatabase): CallHistoryDao = db.callHistoryDao()
}
