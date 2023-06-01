package com.flora30.divelib.data.loot

import org.bukkit.Bukkit
import org.bukkit.Location


class Loot {
    // 座標リスト
    val locationList: ArrayList<LootLocation> = ArrayList()
    // 各レベルの報酬リスト
    // [ lv-1 ]の場所に入っている
    val itemList: MutableList<ArrayList<ItemAmount>> = ArrayList()
    data class ItemAmount(val itemId: Int, val amount: Int)

    init {
        itemList.add(arrayListOf())
        itemList.add(arrayListOf())
        itemList.add(arrayListOf())
    }

    fun getLootLoc(id: Int): LootLocation? {
        return try {
            locationList[id]
        } catch (e: IndexOutOfBoundsException) {
            Bukkit.getLogger().info("[DiveCore-Loot]座標id[" + id + "]が存在数[" + locationList.size + "]を越えました")
            null
        }
    }

    fun getID(location: Location): Int {
        //無い場合は-1
        for (i in locationList.indices) {
            val lootLoc = locationList[i]
            if (lootLoc.check(location)) {
                return i
            }
        }
        return -1
    }
}
