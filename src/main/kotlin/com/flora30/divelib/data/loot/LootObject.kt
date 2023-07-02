package com.flora30.divelib.data.loot

import com.flora30.divelib.data.gimmick.action.ChestType
import org.bukkit.Material
import java.util.*

object LootObject {
    // 報酬ID | 報酬データ
    val lootItemMap = hashMapOf<String,ArrayList<ItemAmount>>()

    // ChestTypeごとのワールド表示ブロック
    val displayList = hashMapOf<ChestType, Material>()

    // レベルごとのデータ
    val lootLevelList = arrayListOf<LootLevel>()

    // yml取得
    var particleCount = 10
    var particleRange = 1.0
    var particleDistance = 20
    var failedLoot: ItemAmount? = null
    var fillAir = false

    data class ItemAmount(val itemId: Int, val amount: Int)

    /**
     * @return レベル（1～3）
     */
    fun getRandomLootLevel(): Int {
        var reverseList: List<LootLevel?> = ArrayList(lootLevelList)
        reverseList = reverseList.reversed()
        var currentRate = 0.0
        val size = reverseList.size
        for (i in 0 until size-1) {
            currentRate += reverseList[i]!!.percent
            if (Math.random() <= currentRate) {
                //Bukkit.getLogger().info("lootLevel決定 - "+(reverseList.size()-i));
                return size-1 - i
            }
        }
        //Bukkit.getLogger().info("lootLevel決定 - 0");
        return 0
    }
}