package com.flora30.divelib.data.talk

import com.flora30.divelib.data.player.PlayerDataObject
import org.bukkit.entity.Player

class TalkLoop (val time: Int): Talk{
    override fun talk(player: Player, npc: NPC) {
        val data = PlayerDataObject.playerDataMap[player.uniqueId]?.npcData ?: return
        var currentProgress = data.getTalkProgress(npc.npcId)

        if (currentProgress >= npc.talks.size){
            currentProgress = npc.talks.size -1
        }

        if (currentProgress - time < 0) {
            data.talkProgressMap[npc.npcId] = 0
            data.setFirstTalk = true
        }
        else{
            data.talkProgressMap[npc.npcId] = currentProgress - time
        }
    }
}