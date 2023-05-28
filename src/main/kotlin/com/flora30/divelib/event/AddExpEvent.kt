package com.flora30.divelib.event

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

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}