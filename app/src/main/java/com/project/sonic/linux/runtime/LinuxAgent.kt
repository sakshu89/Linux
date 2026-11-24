package com.project.sonic.linux.runtime

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class LinuxAgent(private val context: Context) {
    private val store = ModelStore(context)
    private val thinker = LlamaRuntime()
    private val needle = NeedleRuntime()
    @Volatile private var ready = false

    suspend fun prepare(): Boolean = withContext(Dispatchers.IO) {
        try {
            store.ensureNeedle()
            store.ensureQwen()
            val n = needle.load(store.needleFile().absolutePath)
            val q = thinker.load(store.qwenFile().absolutePath)
            ready = n && q
            ready
        } catch (_: Throwable) { false }
    }

    suspend fun think(userText: String, toolsJson: String): String = withContext(Dispatchers.Default) {
        check(ready) { "Linux local models are not ready" }
        val prompt = """<|im_start|>system\nYou are Linux, an Android agent. Be concise. Decide whether to answer directly or describe the next action. Never claim an Android action succeeded unless the action layer reports success.\nTools:\n$toolsJson<|im_end|>\n<|im_start|>user\n$userText<|im_end|>\n<|im_start|>assistant\n"""
        thinker.complete(prompt)
    }

    suspend fun toolCalls(userText: String, toolsJson: String): String = withContext(Dispatchers.Default) {
        check(ready) { "Linux local models are not ready" }
        val messages = JSONObject().put("role", "user").put("content", userText).let { org.json.JSONArray().put(it) }.toString()
        needle.complete(messages, toolsJson)
    }

    fun close() { thinker.close(); needle.close(); ready = false }
}
