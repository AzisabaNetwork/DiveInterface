package com.flora30.divelib.data.talk

import org.bukkit.entity.Player

interface Talk {
    fun talk(player: Player, npc: NPC)
}