package com.project.sonic.linux.runtime

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LinuxAgentService : Service() {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val text = intent?.getStringExtra(EXTRA_TEXT) ?: return START_NOT_STICKY
        val tools = intent.getStringExtra(EXTRA_TOOLS) ?: DEFAULT_TOOLS
        scope.launch {
            val agent = LinuxRuntimeRegistry.get(applicationContext)
            val ok = agent.prepare()
            val result = if (ok) agent.toolCalls(text, tools) else "{\"function_calls\":[],\"error\":\"Linux local runtime is not ready\"}"
            sendBroadcast(Intent(ACTION_RESULT).setPackage(packageName).putExtra(EXTRA_RESULT, result))
            stopSelf(startId)
        }
        return START_NOT_STICKY
    }
    override fun onDestroy() { scope.coroutineContext.cancel(); super.onDestroy() }
    override fun onBind(intent: Intent?): IBinder? = null
    companion object {
        const val ACTION_RUN = "com.project.linux.RUN_AGENT"
        const val ACTION_RESULT = "com.project.linux.AGENT_RESULT"
        const val EXTRA_TEXT = "text"
        const val EXTRA_TOOLS = "tools"
        const val EXTRA_RESULT = "result"
        const val DEFAULT_TOOLS = "[{\"name\":\"app.open\",\"description\":\"Open an installed Android app\",\"parameters\":{\"type\":\"object\",\"properties\":{\"package\":{\"type\":\"string\"}},\"required\":[\"package\"]}},{\"name\":\"screen.home\",\"description\":\"Go to Android home screen\",\"parameters\":{\"type\":\"object\"}},{\"name\":\"screen.back\",\"description\":\"Press Android back\",\"parameters\":{\"type\":\"object\"}}]"
    }
}
