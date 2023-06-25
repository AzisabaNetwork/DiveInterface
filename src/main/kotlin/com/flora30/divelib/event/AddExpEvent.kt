package com.flora30.divelib.event

import jdk.incubator.foreign.ResourceScope.Handle
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * 後の処理でConstantも扱うのでEvent形式
 */
class AddExpEvent (
    val player: Player,
    val exp: Int
): Event(){

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList
}