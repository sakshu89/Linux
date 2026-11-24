package com.project.sonic

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.project.sonic.linux.runtime.LinuxRuntimeRegistry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/** Launcher screen for the on-device Linux runtime. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = TextView(this).apply {
            text = "Linux"
            textSize = 28f
            setTextColor(Color.WHITE)
        }
        val status = TextView(this).apply {
            text = "Models are not loaded yet"
            setTextColor(Color.LTGRAY)
        }
        val prepareButton = Button(this).apply { text = "Prepare models" }
        val promptInput = EditText(this).apply { hint = "Ask Linux" }
        val runButton = Button(this).apply { text = "Run" }
        val resultText = TextView(this).apply {
            text = ""
            setTextColor(Color.WHITE)
        }

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP
            setPadding(32, 32, 32, 32)
            addView(title)
            addView(status)
            addView(prepareButton)
            addView(promptInput)
            addView(runButton)
            addView(resultText)
        }

        prepareButton.setOnClickListener {
            prepareButton.isEnabled = false
            status.text = "Preparing local models — first run downloads the model files."
            lifecycleScope.launch {
                val ok = withContext(Dispatchers.IO) {
                    try {
                        LinuxRuntimeRegistry.get(this@MainActivity).prepare()
                    } catch (_: Throwable) {
                        false
                    }
                }
                status.text = if (ok) "Ready — models loaded" else "Prepare failed — check network and storage"
                prepareButton.isEnabled = true
            }
        }

        runButton.setOnClickListener {
            val prompt = promptInput.text.toString().trim()
            if (prompt.isEmpty()) {
                resultText.text = "Type a prompt first."
                return@setOnClickListener
            }
            runButton.isEnabled = false
            resultText.text = "Thinking…"
            lifecycleScope.launch {
                resultText.text = withContext(Dispatchers.Default) {
                    try {
                        LinuxRuntimeRegistry.get(this@MainActivity).think(prompt, "[]")
                    } catch (e: Throwable) {
                        "Error: ${e.message}"
                    }
                }
                runButton.isEnabled = true
            }
        }

        setContentView(ScrollView(this).apply { addView(content) })
    }
}
