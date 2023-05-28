package com.flora30.divelib

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class DiveLib: JavaPlugin() {
    companion object {
        lateinit var plugin: DiveLib
    }

    init {
        plugin = this
    }

    // 準備が出来たプラグインのフラグ
    var itemDataReady: Boolean = false
    var itemStackReady: Boolean = false
    var storyReady: Boolean = false
    var coreEventReady: Boolean = false
    var questEventReady: Boolean = false

    // Task用のscheduler
    val scheduler: BukkitScheduler = Bukkit.getServer().scheduler

    // 毎tick更新される現在時間（ms単位、ラグ検出用）
    var lagTime: Long = 0


    override fun onEnable() {
        super.onEnable()
        config.getString("")
        // config読込み処理

        tick()
    }

    private fun tick(){
        scheduler.scheduleSyncDelayedTask(this,{
            tick() // 一番上に置く

            lagTime = System.currentTimeMillis()
        },1L)
    }

    fun delayedTask(delay: Int, task: Runnable) {
        scheduler.scheduleSyncDelayedTask(this, task, delay.toLong())
    }


}