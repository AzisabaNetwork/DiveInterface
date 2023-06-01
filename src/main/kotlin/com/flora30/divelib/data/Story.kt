package com.flora30.divelib.data

import com.flora30.divelib.DiveLib
import com.flora30.divelib.data.player.PlayerDataObject
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class Story (
    val displaySub: String,
    val storyList: ArrayList<String>,
    val noticeDisplay: Boolean
){
    fun play(player: Player) {
        var count = 0
        val delay: Int = PlayerDataObject.playerDataMap[player.uniqueId]?.layerData?.storySpeed ?: return
        for (str in storyList) {
            val task: BukkitRunnable = object : BukkitRunnable() {
                override fun run() {
                    player.sendMessage(str)
                    player.playSound(player.location, Sound.ENTITY_PUFFER_FISH_BLOW_UP, 1f, 1f)
                }
            }
            DiveLib.plugin.delayedTask(count * delay, task)
            count++
        }
    }
}