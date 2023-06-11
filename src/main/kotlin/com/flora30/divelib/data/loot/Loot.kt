package com.flora30.divelib.data.loot

import com.flora30.divelib.data.gimmick.action.ChestType
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material


class Loot {
    // ChestType（種類）ごとの報酬リスト
    val itemList = hashMapOf<ChestType,ArrayList<ItemAmount>>()

    // 座標リスト
    //val locationList: ArrayList<LootLocation> = ArrayList()
    // 各レベルの報酬リスト
    // [ lv-1 ]の場所に入っている
    //val itemList: MutableList<ArrayList<ItemAmount>> = ArrayList()
    data class ItemAmount(val itemId: Int, val amount: Int)

    init {
        for (type in ChestType.values()){
            itemList[type] = arrayListOf()
        }
    }
}
