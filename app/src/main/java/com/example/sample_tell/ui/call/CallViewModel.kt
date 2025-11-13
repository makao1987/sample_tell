package com.example.sample_tell.ui.call

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_tell.data.entity.CallHistory
import com.example.sample_tell.data.repository.CallRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class CallViewModel @Inject constructor(
    private val repository: CallRepository
) : ViewModel() {

    private val _history = mutableStateOf<List<CallHistory>>(emptyList())
    val history: State<List<CallHistory>> = _history

    fun loadHistory() {
        viewModelScope.launch {
            _history.value = repository.getAll()
        }
    }

    fun startCall(context: Context, roomName: String) {
        val options = JitsiMeetConferenceOptions.Builder()
            .setServerURL(URL("https://meet.jit.si"))
            .setRoom(roomName)
            .build()
        JitsiMeetActivity.launch(context, options)

        viewModelScope.launch {
            repository.save(roomName)
        }
    }
}
