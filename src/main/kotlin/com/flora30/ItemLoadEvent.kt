package com.flora30

import io.lumine.xikage.mythicmobs.io.MythicConfig
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class ItemLoadEvent(
    val id: Int,
    val section: MythicConfig
): Event() {

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }

}