package com.flora30.diveapin.util

import com.flora30.diveapin.DiveAPIN
import com.flora30.diveapin.ItemEntityObject
import com.flora30.diveapin.ItemMain
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import java.lang.NumberFormatException

object PlayerItem {

    /**
     * プレイヤーにアイテムを与える
     */
    fun giveItem(player: Player, item: ItemStack) {
        val inventory = player.inventory

        // インベントリが埋まっているときは外に出す
        if (inventory.firstEmpty() == -1) {
            ItemEntityObject.spawnItem(item,player.location.add(0.0,1.0,0.0),player)
            return
        }

        inventory.addItem(item)
    }

    /**
     * プレイヤーのアイテム所持数を数える
     */
    fun countItem(player: Player, id: Int, isOnlyPlayerInv: Boolean):Int {
        var count = 0
        val inventory = player.inventory
        for (item in inventory) {
            if (getInt(item,"id") == id){
                count += item.amount
            }
        }

        // エンダーチェスト判定
        if (!isOnlyPlayerInv){
            val ender = player.enderChest
            for (item in ender){
                if (getInt(item,"id") == id) {
                    count += item.amount
                }
            }
        }
        return count
    }

    /**
     * プレイヤーからアイテムを取る
     */
    fun takeItem(player: Player, id: Int, amount: Int){
        var take = amount
        val inventory = player.inventory
        for (item in inventory){
            if (item == null) continue

            // IDが同じとき
            if (ItemMain.getItemId(item) == id) {
                val current = item.amount

                // currentが多い = 終了
                if (current > take){
                    item.amount -= current
                    take = 0
                }
                else{
                    // amountが多い = 終わらない
                    take -= current
                    inventory.remove(item)
                }
            }

            if (take <= 0) break
        }
    }

    fun getString(item: ItemStack, key: String):String? {
        if(item.itemMeta == null) return null
        return item.itemMeta.persistentDataContainer.get(NamespacedKey(DiveAPIN.plugin,key), PersistentDataType.STRING)
    }

    fun getInt(item: ItemStack, key: String):Int {
        if(item.itemMeta == null) return -1
        return try {
            item.itemMeta.persistentDataContainer.getOrDefault(NamespacedKey(DiveAPIN.plugin,key), PersistentDataType.STRING,"-1").toInt()
        } catch (e: NullPointerException) {
            -1
        } catch (e: NumberFormatException) {
            -1
        }
    }
}