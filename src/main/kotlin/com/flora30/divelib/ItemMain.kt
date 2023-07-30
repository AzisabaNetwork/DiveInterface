package com.flora30.divelib

import com.flora30.divelib.event.GetItemEvent
import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.items.ItemManager
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

object ItemMain {
    val itemManager: ItemManager = ItemManager(Bukkit.getPluginManager().getPlugin("MythicMobs") as MythicMobs)

    // アイテムそのもの
    val itemMap: Map<Int, ItemStack> = HashMap()
    val mythicItemMap: Map<Int, String> = HashMap()

    fun getItem(id: Int):ItemStack? {
        if (id == -1) return null
        val item: ItemStack = getNeutralItem(id) ?: return null

        val event = GetItemEvent(id,item,null,false)
        Bukkit.getPluginManager().callEvent(event)
        if (event.isCancelled){
            Bukkit.getLogger().info("[DiveCore-Item]ID-"+id+"の情報生成がキャンセルされました（アイテム不足？）")
            return getNeutralItem(id)
        }
        // gatherConfigはeventの最後で
        return event.item;
    }

    fun getItemAsync(id: Int):ItemStack? {
        if (id == -1) return null
        val item: ItemStack = getNeutralItem(id) ?: return null

        val event = GetItemEvent(id,item,null,true)
        Bukkit.getPluginManager().callEvent(event)
        if (event.isCancelled){
            Bukkit.getLogger().info("[DiveCore-Item]ID-"+id+"の情報生成がキャンセルされました（アイテム不足？）")
            return getNeutralItem(id)
        }
        // gatherConfigはeventの最後で
        return event.item;
    }

    fun getNeutralItem(id: Int):ItemStack? {
        if (id == -1) return null

        return if (mythicItemMap.containsKey(id)){
            callMMItem(mythicItemMap[id]!!)
        } else if (itemMap.containsKey(id)){
            itemMap[id]!!.clone()
        } else {
            null
        }
    }
    //MMアイテムの呼び出し
    fun callMMItem(mmName: String):ItemStack {
        return itemManager.getItemStack(mmName)
    }


    // itemId取得
    fun getItemId(item: ItemStack?):Int {
        if (item == null || item.itemMeta == null) return -1
        return Integer.parseInt(item.itemMeta.persistentDataContainer.getOrDefault(
            NamespacedKey(DiveLib.plugin,"id"),
            PersistentDataType.STRING,"-1"))
    }

    // ランダム値を指定してアイテム取得
    fun getItemWithValue(id: Int, s1: String, isAsync: Boolean): ItemStack?{
        if (id == -1) return null
        val item: ItemStack = getNeutralItem(id) ?: return null

        val event = GetItemEvent(id,item,s1,isAsync)
        Bukkit.getPluginManager().callEvent(event)
        if (event.isCancelled){
            Bukkit.getLogger().info("[DiveAPIN-Item]ID-"+id+"の情報生成がキャンセルされました（アイテム不足？）")
            return getNeutralItem(id)
        }
        // gatherConfigはeventの最後で
        return event.item
    }

}