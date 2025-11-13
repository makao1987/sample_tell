package com.example.sample_tell.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sample_tell.data.dao.CallHistoryDao
import com.example.sample_tell.data.entity.CallHistory

@Database(entities = [CallHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun callHistoryDao(): CallHistoryDao
}
