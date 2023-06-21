package com.flora30.divelib.event

import org.bukkit.configuration.ConfigurationSection
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class LayerLoadEvent(
    val key: String,
    val section: ConfigurationSection
): Event() {

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}