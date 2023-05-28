package com.flora30.divelib.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.inventory.ItemStack

class SaveItemEvent (
    val item: ItemStack,
    var additionalValue: String?
): Event(){

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}