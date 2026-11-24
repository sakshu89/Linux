package com.project.sonic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.sonic.linux.runtime.LinuxRuntimeRegistry
import kotlinx.coroutines.launch

/** Launcher screen for the on-device Linux runtime. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LinuxHome()
                }
            }
        }
    }

    @Composable
    private fun LinuxHome() {
        val scope = rememberCoroutineScope()
        var status by remember { mutableStateOf("Models are not loaded yet") }
        var prompt by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }
        var busy by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Linux", style = MaterialTheme.typography.headlineLarge)
            Text(status, style = MaterialTheme.typography.bodyMedium)

            if (busy) {
                CircularProgressIndicator()
            }

            Button(
                onClick = {
                    scope.launch {
                        busy = true
                        status = "Preparing local models — the first run downloads the model files."
                        val ok = try {
                            LinuxRuntimeRegistry.get(this@MainActivity).prepare()
                        } catch (_: Throwable) {
                            false
                        }
                        status = if (ok) "Ready — models loaded" else "Prepare failed — check network and storage"
                        busy = false
                    }
                },
                enabled = !busy
            ) {
                Text("Prepare models")
            }

            OutlinedTextField(
                value = prompt,
                onValueChange = { prompt = it },
                label = { Text("Ask Linux") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            Button(
                onClick = {
                    scope.launch {
                        busy = true
                        result = try {
                            LinuxRuntimeRegistry.get(this@MainActivity).think(prompt, "[]")
                        } catch (e: Throwable) {
                            "Error: ${e.message}"
                        }
                        busy = false
                    }
                },
                enabled = !busy && prompt.isNotBlank()
            ) {
                Text("Run")
            }

            if (result.isNotBlank()) {
                Text("Result", style = MaterialTheme.typography.titleMedium)
                Text(result, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
