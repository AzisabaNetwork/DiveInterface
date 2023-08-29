package com.flora30.divelib.data.talk

import com.flora30.divelib.ItemMain
import com.flora30.divelib.util.PlayerItem
import org.bukkit.entity.Player

class TalkGiveItem(
    val itemId: Int,
    val amount: Int
): Talk {
    override fun talk(player: Player, npc: NPC) {
        val item = ItemMain.getItem(itemId)!!
        item.amount = amount
        PlayerItem.giveItem(player, item)
    }
}