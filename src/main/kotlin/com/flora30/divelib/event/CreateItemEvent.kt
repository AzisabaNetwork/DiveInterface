package com.flora30.divelib.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class CreateItemEvent (
    val id: Int
): Event(){

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}