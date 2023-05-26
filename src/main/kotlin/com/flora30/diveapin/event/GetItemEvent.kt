package com.flora30.diveapin.event

import com.flora30.diveapin.DiveAPIN
import org.bukkit.NamespacedKey
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataType

class GetItemEvent (
    val id: Int,
    val item: ItemStack,
    var additionalValue: String?,
    val isAsync: Boolean
):Event(isAsync) {

    var isCancelled: Boolean = false


    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }

    fun setString(key: String, value: String){
        if (item.itemMeta != null) {
            val meta: ItemMeta = item.itemMeta
            meta.persistentDataContainer.set(NamespacedKey(DiveAPIN.plugin,key), PersistentDataType.STRING,value)
            item.itemMeta = meta
        }
    }
    fun setString(key: String, value: Int){
        if (item.itemMeta != null) {
            val meta: ItemMeta = item.itemMeta
            meta.persistentDataContainer.set(NamespacedKey(DiveAPIN.plugin,key), PersistentDataType.STRING,value.toString())
            item.itemMeta = meta
        }
    }
    fun setString(key: String, value: Double){
        if (item.itemMeta != null) {
            val meta: ItemMeta = item.itemMeta
            meta.persistentDataContainer.set(NamespacedKey(DiveAPIN.plugin,key), PersistentDataType.STRING,value.toString())
            item.itemMeta = meta
        }
    }
}