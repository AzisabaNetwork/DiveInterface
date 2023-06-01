package com.flora30.divelib.data.talk

import com.flora30.divelib.data.player.PlayerDataObject
import org.bukkit.entity.Player

class TalkMoney (val amount: Int): Talk{
    override fun talk(player: Player, npc: NPC) {
        val data = PlayerDataObject.playerDataMap[player.uniqueId] ?: return
        data.money += amount
    }
}