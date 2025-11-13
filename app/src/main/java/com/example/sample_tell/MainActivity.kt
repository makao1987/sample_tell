package com.example.sample_tell

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Jitsi SDK の初期化（オプション）
        val defaultOptions = JitsiMeetConferenceOptions.Builder()
            .setServerURL(URL("https://meet.jit.si"))
            .build()
        JitsiMeet.setDefaultConferenceOptions(defaultOptions)

        setContent {
            MaterialTheme {
                CallEntryScreen()
            }
        }
    }
}

@Composable
fun CallEntryScreen() {
    var roomName by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text(text = "部屋名を入力してください", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = roomName,
            onValueChange = { roomName = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                val options = JitsiMeetConferenceOptions.Builder()
                    .setRoom(roomName)
                    .build()
                JitsiMeetActivity.launch(context, options)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("通話を開始")
        }
    }
}
