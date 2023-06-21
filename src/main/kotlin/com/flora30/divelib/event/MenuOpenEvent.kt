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

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}