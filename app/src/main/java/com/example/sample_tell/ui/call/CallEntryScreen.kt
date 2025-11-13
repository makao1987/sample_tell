package com.example.sample_tell.ui.call

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CallEntryScreen() {
    val viewModel: CallViewModel = hiltViewModel()
    var roomName by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = "部屋名を入力してください")
        TextField(
            value = roomName,
            onValueChange = { roomName = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { viewModel.startCall(context, roomName) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("通話を開始")
        }
    }
}