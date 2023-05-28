package com.flora30.divelib.event

import com.flora30.divelib.data.MenuSlot
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.inventory.ItemStack

class MenuClickEvent (
    val player: Player,
    val slot: MenuSlot,
    val icon: ItemStack
): Event(){
    var useClickSound = false

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}