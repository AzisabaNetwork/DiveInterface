package com.flora30.diveapin.event

import org.bukkit.configuration.ConfigurationSection
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class LayerLoadEvent(
    val key: String,
    val section: ConfigurationSection
): Event() {

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}