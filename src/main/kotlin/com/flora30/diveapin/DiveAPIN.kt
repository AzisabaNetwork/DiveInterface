package com.flora30.diveapin

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class DiveAPIN: JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    init {
        plugin = this
    }

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


}