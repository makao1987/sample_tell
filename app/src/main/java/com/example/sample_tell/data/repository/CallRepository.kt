package com.example.sample_tell.data.repository

import android.content.Context
import com.example.sample_tell.data.dao.CallHistoryDao
import com.example.sample_tell.data.entity.CallHistory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CallRepository @Inject constructor(
    private val dao: CallHistoryDao,
) {
    suspend fun save(roomName: String) {
        val history = CallHistory(roomName = roomName, timestamp = System.currentTimeMillis())
        dao.insert(history)
    }

    suspend fun getAll(): List<CallHistory> = dao.getAll()
}
