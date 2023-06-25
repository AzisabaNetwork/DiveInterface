package com.flora30.divelib.event

import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

// ドロップしたアイテムが個人登録されるときのイベント
class PutItemEntityEvent (
    val item: Item,
    val player: Player
): Event(),Cancellable {
    private var isCancelled = false

    companion object{
        private val handlerList = HandlerList()
        @JvmStatic private fun getHandlerList(): HandlerList = handlerList
    }
    override fun getHandlers(): HandlerList = handlerList

    override fun isCancelled(): Boolean {
        return isCancelled
    }

    override fun setCancelled(cancel: Boolean) {
        isCancelled = cancel
    }
}