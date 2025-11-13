package com.example.sample_tell.data.dao

import androidx.room.*
import com.example.sample_tell.data.entity.CallHistory

@Dao
interface CallHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(history: CallHistory)

    @Query("SELECT * FROM call_history ORDER BY timestamp DESC")
    suspend fun getAll(): List<CallHistory>
}
