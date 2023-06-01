package com.flora30.divelib.util

import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitRunnable

object Schedular {
    fun Plugin.runTaskTimer(delay: Int, period: Int, task: BukkitRunnable) {
        this.runTaskTimer(delay,period,task)
    }
}