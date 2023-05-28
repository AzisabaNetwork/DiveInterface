package com.flora30.diveapin.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.util.*

class LayerChangeEvent(
    val uuid: UUID,
    val nextLayer: String,
    val isAsync: Boolean
): Event(isAsync) {

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}