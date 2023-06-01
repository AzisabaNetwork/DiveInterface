package com.flora30.divelib.data.talk

import com.flora30.divelib.gui.WhistleGUI
import org.bukkit.entity.Player

class TalkWhistle: Talk {
    override fun talk(player: Player, npc: NPC) {
        player.openInventory(WhistleGUI.getGui(player))
    }
}