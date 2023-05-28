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

    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }

    override fun isCancelled(): Boolean {
        return isCancelled
    }

    override fun setCancelled(cancel: Boolean) {
        isCancelled = cancel
    }
}