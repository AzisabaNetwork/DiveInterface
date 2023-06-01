package com.flora30.divelib.data.talk

import org.bukkit.ChatColor
import org.bukkit.entity.Player

class TalkText (text: String): Talk{
    val text: String
    init {
        this.text = ChatColor.translateAlternateColorCodes('&',text)
    }
    override fun talk(player: Player, npc: NPC) {
        player.sendMessage(text)
    }
}