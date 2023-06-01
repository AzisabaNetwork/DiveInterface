package com.flora30.divelib.data.loot

import com.flora30.divelib.BlockLoc
import com.flora30.divelib.data.LayerObject

object LootObject {
    // 階層ID | ルートチェストデータ
    val lootMap = hashMapOf<String,Loot>()
    // 階層ID |
    val amountMap = hashMapOf<String,Int>()

    // レベルごとのデータ
    val lootLevelList = arrayListOf<LootLevel>()

    // yml取得
    var particleCount = 10
    var particleRange = 1.0
    var particleDistance = 20
    var failedLoot: Loot.ItemAmount? = null
    var fillAir = false

    fun isLootLocation(blockLoc: BlockLoc): Boolean{
        val layer: String? = LayerObject.getLayerName(blockLoc.getLocation())
        val loot: Loot = lootMap[layer] ?: return false

        for (lootLoc in loot.locationList) {
            if (blockLoc.z == lootLoc.blockZ && blockLoc.y == lootLoc.blockY && blockLoc.x == lootLoc.blockZ) {
                return true
            }
        }
        return false
    }
}