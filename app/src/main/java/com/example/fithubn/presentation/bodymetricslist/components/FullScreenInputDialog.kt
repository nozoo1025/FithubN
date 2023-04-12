package com.example.fithubn.presentation.bodymetricslist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun FullScreenInputDialog() {
    var showDialog by remember { mutableStateOf(true) }
    val onDismissRequest = { showDialog = false }

    if (showDialog) {
        Dialog(onDismissRequest = onDismissRequest) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                ) {
                    val textState = remember { mutableStateOf("") }

                    TextField(
                        value = textState.value,
                        onValueChange = { newText -> textState.value = newText },
                        label = { Text("Enter text") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {
                        Button(
                            onClick = { onDismissRequest() },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Cancel")
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Button(
                            onClick = {
                                onDismissRequest()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Confirm")
                        }
                    }
                }
            }
        }
    }
}
