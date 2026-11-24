package com.project.sonic.linux.runtime

class LlamaRuntime {
    private var handle: Long = 0
    fun load(model: String): Boolean { if (handle != 0L) return true; handle = nativeLoad(model); return handle != 0L }
    fun complete(prompt: String): String { check(handle != 0L) { "Qwen runtime is not loaded" }; return nativeComplete(handle, prompt) }
    fun close() { if (handle != 0L) { nativeFree(handle); handle = 0 } }
    private external fun nativeLoad(path: String): Long
    private external fun nativeComplete(handle: Long, prompt: String): String
    private external fun nativeFree(handle: Long)
    companion object { init { System.loadLibrary("linux_llama") } }
}
