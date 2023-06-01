package com.flora30.divelib.data.talk

import com.flora30.divelib.data.player.PlayerDataObject
import org.bukkit.entity.Player

class CheckOther(
    val npcId: Int,
    val progress: Int,
    val failStr: String
):Check(failStr) {
    override fun check(player: Player, npc: NPC): Boolean {
        val data = PlayerDataObject.playerDataMap[player.uniqueId]?.npcData ?: return false

        return if (data.getTalkProgress(npcId) >= progress){
            true
        } else{
            falsedText(player,npc)
            false
        }
    }
}