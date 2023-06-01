package com.flora30.divelib.data.penalty

import com.flora30.divelib.data.player.PlayerDataObject
import org.bukkit.entity.Player

class PenaltyFood (
    val amount: Int // 食料ゲージを減少させる量
): Penalty{
    override fun execute(player: Player) {
        val playerData = PlayerDataObject.playerDataMap[player.uniqueId] ?: return
        val current = playerData.food

        playerData.food = (current - amount).coerceAtLeast(0)
    }
}