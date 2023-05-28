package com.flora30.diveapin.data

import org.bukkit.inventory.ItemStack
import java.util.*

class TradeData (
    val to: UUID
){
    var phase = TradePhase.Invite
    var inviteTime = 0
    val items = arrayListOf<ItemStack?>()

    init {
        for (i in 0..14){
            items.add(null)
        }
    }
}