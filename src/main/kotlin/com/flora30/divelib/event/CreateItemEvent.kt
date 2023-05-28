package com.flora30.diveapin.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class CreateItemEvent (
    val id: Int
): Event(){

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}