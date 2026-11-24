package com.project.sonic.linux.runtime

import android.content.Context
import java.io.File
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

class ModelStore(private val context: Context) {
    private val dir get() = File(context.filesDir, "linux-models").apply { mkdirs() }
    fun qwenFile() = File(dir, LinuxConfig.QWEN_MODEL_FILE)
    fun needleFile() = File(dir, LinuxConfig.NEEDLE_MODEL_FILE)

    suspend fun ensureQwen(onProgress: (Long, Long) -> Unit = {_,_->}) = downloadIfMissing(LinuxConfig.QWEN_MODEL_URL, qwenFile(), onProgress)
    suspend fun ensureNeedle(onProgress: (Long, Long) -> Unit = {_,_->}) = downloadIfMissing(LinuxConfig.NEEDLE_MODEL_URL, needleFile(), onProgress)

    private suspend fun downloadIfMissing(url: String, target: File, onProgress: (Long, Long) -> Unit): File {
        if (target.isFile && target.length() > 0) return target
        val tmp = File(target.parentFile, target.name + ".part")
        val c = URL(url).openConnection() as HttpURLConnection
        c.connectTimeout = 20000; c.readTimeout = 60000; c.requestMethod = "GET"
        c.connect()
        if (c.responseCode !in 200..299) throw IllegalStateException("Model download failed: HTTP ${c.responseCode}")
        val total = c.contentLengthLong
        var done = 0L
        BufferedInputStream(c.inputStream, 1024 * 1024).use { input ->
            FileOutputStream(tmp).use { out ->
                val buf = ByteArray(1024 * 1024)
                while (true) { val n = input.read(buf); if (n < 0) break; out.write(buf, 0, n); done += n; onProgress(done, total) }
                out.fd.sync()
            }
        }
        c.disconnect()
        if (total > 0 && tmp.length() != total) throw IllegalStateException("Incomplete model download")
        if (!tmp.renameTo(target)) throw IllegalStateException("Could not install model")
        return target
    }
}
