package com.flora30.divelib.event

import io.lumine.xikage.mythicmobs.io.MythicConfig
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class ItemLoadEvent(
    val id: Int,
    val section: MythicConfig
): Event() {

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList

}