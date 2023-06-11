package com.flora30.divelib.data.gimmick.action

import com.flora30.divelib.data.GData
import com.flora30.divelib.data.loot.LootObject
import com.flora30.divelib.data.player.LootData
import com.flora30.divelib.data.player.PlayerDataObject

class GASpawnChest (
    val type: ChestType
): GAction{
    override fun execute(data: GData) {
        // レベルは自動生成
        val level = LootObject.getRandomLootLevel()
        val lootData = LootData(type,level)
        val layerData = PlayerDataObject.playerDataMap[data.player.uniqueId]?.layerData ?: return

        // PlayerDataに追加
        layerData.lootMap[data.location] = lootData
    }
}