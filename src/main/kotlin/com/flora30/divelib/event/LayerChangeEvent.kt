package com.flora30.divelib.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.util.*

class LayerChangeEvent(
    val uuid: UUID,
    val nextLayer: String,
    val isAsync: Boolean
): Event(isAsync) {

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}