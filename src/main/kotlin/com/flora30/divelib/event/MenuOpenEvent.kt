package com.flora30.divelib.event

import com.flora30.divelib.data.MenuSlot
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.inventory.ItemStack

class MenuOpenEvent (
    val player: Player,
    val iconMap: Map<MenuSlot,ItemStack>
): Event(){

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}