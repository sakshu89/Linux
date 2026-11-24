package com.project.sonic.linux.runtime

import android.content.Context

object LinuxRuntimeRegistry {
    @Volatile private var agent: LinuxAgent? = null
    fun get(context: Context): LinuxAgent = synchronized(this) {
        agent ?: LinuxAgent(context.applicationContext).also { agent = it }
    }
    fun shutdown() { synchronized(this) { agent?.close(); agent = null } }
}
