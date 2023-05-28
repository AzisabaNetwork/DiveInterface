package com.flora30.divelib.event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class HelpEvent (
    val player: Player,
    val type: HelpType
    ): Event() {

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}