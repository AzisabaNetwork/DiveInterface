package com.flora30.divelib.data.talk

import com.flora30.divelib.event.HelpEvent
import com.flora30.divelib.event.HelpType
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class TalkHelp (val type: HelpType): Talk{
    override fun talk(player: Player, npc: NPC) {
        Bukkit.getPluginManager().callEvent(HelpEvent(player,type))
    }
}