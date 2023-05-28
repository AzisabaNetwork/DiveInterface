package com.flora30.divelib.event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class FirstJoinEvent(
    val player: Player
): Event() {

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}