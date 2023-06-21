package com.flora30.divelib.event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class FirstJoinEvent(
    val player: Player
): Event() {

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}